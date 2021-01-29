package com.anticpu.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anticpu.model.Uom;
import com.anticpu.repository.UomRepository;
import com.anticpu.service.UomService;

@Service
public class UomImpl implements UomService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UomImpl.class);
	
	@Autowired
	private UomRepository repo;

	@Override
	public Integer saveUom(Uom uom) {
		
		LOGGER.info("Inside saveUom() : uom ="+uom);

		Uom u = repo.save(uom);
		LOGGER.info("uom u ="+u);
		return u.getId();
	}

	@Override
	public List<Uom> getUomsList() {
		LOGGER.info("Inside getUomsList");
		return repo.findAll();
	}

	@Override
	public void deleteUom(Integer id) {
		LOGGER.info("Inside deleteUom() :"+id);
		repo.deleteById(id);
	}

	@Override
	public boolean isUomExist(Integer id) {
		LOGGER.info("Inside isUomExist() ="+id);
		return repo.existsById(id);
	}

	@Override
	public Uom getShipmentById(Integer Id) {
		LOGGER.info("Inside getShipmentById()="+Id);
		return repo.getOne(Id);
	}

	@Override
	public Optional<Uom> getOneUom(Integer id) {
		LOGGER.info("Inside getOneUom()="+id);
		return repo.findById(id);
	}

	@Override
	public void updateUom(Uom uom) {
		LOGGER.info("Inside getOneUom()="+uom);
		repo.save(uom);
	}

}
