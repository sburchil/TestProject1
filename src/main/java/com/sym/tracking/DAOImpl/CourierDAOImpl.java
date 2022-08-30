package com.sym.tracking.DAOImpl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sym.tracking.DAO.CourierDAO;
import com.sym.tracking.Entity.Courier;
import com.sym.tracking.Mapper.CourierRowMapper;

@Repository
public class CourierDAOImpl implements CourierDAO {



	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;

	
	Number key;

	private final String INSERT_Courier2 = "INSERT INTO courier " 
			+ "(courierName, courierContactName, courierWebSite, courierContactNumber, courierAddress, "
			+ "courierContactEmail, courierNotes, courierSLA, courierStatus, courierTrackingIdFormat, "
			+ "courierTrackingIdMsg, courierCode, createdDate) VALUES "
			+ "(?, ?, ?, ?, ?, "
			+ "?, ?, ?, ?, ?, "
			+ "?, ?, ?)";		
			
	private final String UPDATE_Courier = "UPDATE courier SET courierName = :courierName, courierContactName = :courierContactName, "
			+ "courierWebSite = :courierWebSite, courierContactNumber = :courierContactNumber, courierAddress = :courierAddress, "
			+ "courierContactEmail = :courierContactEmail, courierNotes = :courierNotes, courierSLA = :courierSLA, courierStatus = :courierStatus, "
			+ "courierTrackingIdFormat = :courierTrackingIdFormat, courierTrackingIdMsg = :courierTrackingIdMsg, courierCode = :courierCode, "
			+ "modifiedDate = :modifiedDate WHERE courierId = :courierId";

	private final String SELECT_courier = "SELECT * FROM courier WHERE courierId = ?";

	private final String SELECT_ALL_courier = "SELECT * FROM courier WHERE courierName LIKE ?";

	@Override
	public Courier addCourier(Courier objCourier) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		int result = jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(INSERT_Courier2, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, objCourier.getCourierName());
			ps.setString(2, objCourier.getCourierContactName());
			ps.setString(3, objCourier.getCourierWebSite());
			ps.setString(4, objCourier.getCourierContactNumber());
			ps.setString(5, objCourier.getCourierAddress());
			ps.setString(6, objCourier.getCourierContactEmail());
			ps.setString(7, objCourier.getCourierNotes());
			ps.setString(8, objCourier.getCourierSLA());
			ps.setString(9, objCourier.getCourierStatus());
			ps.setString(10, objCourier.getCourierTrackingIdFormat());
			ps.setString(11, objCourier.getCourierTrackingIdMsg());
			ps.setString(12, objCourier.getCourierCode());
			ps.setString(13, objCourier.getCreatedDate());
			return ps;
				}, keyHolder);
		long courierId = keyHolder.getKey().longValue();

		if(result > 0) {
			objCourier.setCourierId(courierId);
			return objCourier;
		} else {
			return null;
		}
	}

	@Override
	public int updateCourier(Courier objCourier){
		SqlParameterSource Parameters = new BeanPropertySqlParameterSource(objCourier);
		int result = namedJdbcTemplate.update(UPDATE_Courier, Parameters);
		if(result > 0) {
			return result;
		} else {
			return 0;
		}
	}

	@Override
	public List<Courier> getAllCouriers(String searchedCourier){
		List<Courier> listCourier = jdbcTemplate.query(SELECT_ALL_courier, new CourierRowMapper(), searchedCourier);

		return listCourier;
	}

	@Override
	public Courier getCourierById(long id) {
		Courier objCourier = jdbcTemplate.queryForObject(SELECT_courier, new CourierRowMapper(), id);

		if(objCourier != null){
			return objCourier;
		} else
			return null;
	}
}
