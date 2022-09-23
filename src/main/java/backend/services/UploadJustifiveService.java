package backend.services;

import backend.entities.JustificationEntity;
import backend.repositories.JustificationRepository;
import backend.repositories.StaffRepository;
import backend.entities.StaffEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Service
public class UploadJustifiveService {

    @Autowired
    private JustificationRepository justificationRepository;

    @Autowired
    private StaffRepository staffRepository;

    private Long getIdByRut(String rut){
        try {
            return staffRepository.findByRut(rut).get(0).getIdStaff();
        }catch (Exception e){
            return Integer.toUnsignedLong(0);
        }
    }

    private int saveJustification(Long id, JustificationEntity justificationEntity){
        justificationEntity.setIdStaff(id);
        try{
            justificationRepository.save(justificationEntity);
            return 0;
        }catch (Exception e){
            return 1;
        }

    }

    public int uploadJustifive(String rut, Date date){
        JustificationEntity justificationEntity = new JustificationEntity();
        justificationEntity.setDate(date);
        Long idStaff = getIdByRut(rut);
        if(idStaff == Integer.toUnsignedLong(0)){
            return 1;
        }
        if(saveJustification(idStaff, justificationEntity) == 1){
            return 1;
        }
        return 0;
    }
}
