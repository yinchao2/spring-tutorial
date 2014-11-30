package com.staples.search.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDao")
public class OffersDAO {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Offer> getOffers() {

		return jdbc.query("SELECT * FROM offers", new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setText(rs.getString("text"));
				offer.setEmail(rs.getString("email"));

				return offer;
			}

		});
	}
	
	public boolean update(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		String sql = "UPDATE offers "
					+ "SET name=:name, text=:text, email=:email "
					+ "WHERE id=:id";
		
		return jdbc.update(sql, params) == 1;
	}
	
	public boolean create(Offer offer) {
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		String sql = "INSERT INTO offers (name, text, email) "
					+ "VALUES (:name, :text, :email)";
		
		return jdbc.update(sql, params) == 1;
	}
	
	@Transactional
	public int[] create(List<Offer> offers) {
		
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		
		String sql = "INSERT INTO offers (id, name, text, email) "
					+ "VALUES (:id, :name, :text, :email)";
		
		return jdbc.batchUpdate(sql, params);
	}
	
	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		
		return jdbc.update("DELETE FROM offers WHERE id=:id", params) == 1;
	}

	public Offer getOffer(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("SELECT * FROM offers WHERE id=:id", params,
				new RowMapper<Offer>() {

					public Offer mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Offer offer = new Offer();

						offer.setId(rs.getInt("id"));
						offer.setName(rs.getString("name"));
						offer.setText(rs.getString("text"));
						offer.setEmail(rs.getString("email"));

						return offer;
					}

				});
	}
	
}
