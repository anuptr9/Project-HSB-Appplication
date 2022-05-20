package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.DestinationAlreadyExistsException;
import com.cg.model.AdminDestination;
import com.cg.repository.DestinationRepository;
@Service
public class DestinationServiceImpl implements DestinationService {
	
		private DestinationRepository dstRepo;
		
		@Autowired
		public DestinationServiceImpl(DestinationRepository dstRepo) {
			this.dstRepo=dstRepo;
			
		}

		@Override
		public AdminDestination addDestination(AdminDestination admdst) throws DestinationAlreadyExistsException
		{
			// TODO Auto-generated method stub
			if(dstRepo.existsById(admdst.getDstId())) 
			{
				throw new DestinationAlreadyExistsException();
			}
			AdminDestination savedDestination=dstRepo.save(admdst);
			return savedDestination;
		}
		
		@Override
		public List<AdminDestination> getAllDestinations() {
			return (List<AdminDestination>)dstRepo.findAll();
		}

		@Override
		public void deleteDestinationByDstId(int dstId) {
			dstRepo.deleteById(dstId);
		}

		@Override
		public AdminDestination updateDestination(AdminDestination admdst) {
			AdminDestination dstRecordUpdate;
			Optional<AdminDestination> opt=dstRepo.findById(admdst.getDstId());
			if(opt.isPresent())
			{
				dstRecordUpdate=opt.get();
				dstRecordUpdate.setDstName(admdst.getDstName());
				dstRepo.save(dstRecordUpdate);
			}
			else
			{
				return new AdminDestination();
			}
			return dstRecordUpdate;
		}

}

