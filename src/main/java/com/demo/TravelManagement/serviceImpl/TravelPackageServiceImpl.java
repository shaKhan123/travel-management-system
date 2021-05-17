package com.demo.TravelManagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.TravelManagement.dto.TravelPackageDto;
import com.demo.TravelManagement.entity.TravelPackage;
import com.demo.TravelManagement.error.NotFoundException;
import com.demo.TravelManagement.mapper.TravelPackageMapper;
import com.demo.TravelManagement.repository.TravelPackageRepository;
import com.demo.TravelManagement.service.TravelPackageService;

@Service
public class TravelPackageServiceImpl implements TravelPackageService {

	@Autowired
	TravelPackageRepository travelPackageRepository;

	@Override
	public TravelPackageDto  getDestinations(Long id) throws Exception {
		TravelPackage travelPackage = travelPackageRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("TravelPackage not found - "));
		return TravelPackageMapper.toTravelPackageDto(travelPackage);

	}

	@Override
	public TravelPackageDto  getPassengers(Long id) throws Exception {
		TravelPackage travelPackage = travelPackageRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("TravelPackage not found - "));
		return TravelPackageMapper.toTravelPackageDtoForPassengers(travelPackage);
	}

}
