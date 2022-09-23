package backend.services;


import backend.entities.ExtraHoursEntity;
import backend.repositories.ExtraHoursRepository;
import backend.repositories.StaffRepository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadExtraHoursService {
    @Autowired
    StaffRepository staffRepository;

    @Autowired
    ExtraHoursRepository extraHoursRepository;

    private Long getIdByRut(String rut){
        try {
            return staffRepository.findByRut(rut).get(0).getIdStaff();
        }catch (Exception e){
            return Integer.toUnsignedLong(0);
        }
    }

    private void saveJustification(Long id, ExtraHoursEntity extraHoursEntity){
        extraHoursEntity.setIdStaff(id);
        extraHoursRepository.save(extraHoursEntity);
    }

    public int uploadExtraHours(String rut, Date date, int amount){
        ExtraHoursEntity extraHoursEntity = new ExtraHoursEntity();
        extraHoursEntity.setAmount(amount);
        extraHoursEntity.setDate(date);
        Long idStaff = getIdByRut(rut);
        if(idStaff == Integer.toUnsignedLong(0)){
            return 1;
        }
        saveJustification(idStaff, extraHoursEntity);
        return 0;
    }

}
