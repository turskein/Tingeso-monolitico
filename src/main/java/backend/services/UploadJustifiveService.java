package backend.services;

import backend.entities.JustificationEntity;
import backend.repositories.JustificationRepository;
import backend.repositories.StaffRepository;
import backend.entities.StaffEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UploadJustifiveService {

    @Autowired
    private JustificationRepository justificationRepository;

    @Autowired
    private StaffRepository staffRepository;

    private Long getIdByRut(String rut){
        try {
            return staffRepository.findByRut(rut).get(0).getId_staff();
        }catch (Exception e){
            System.out.println(e);
            return Integer.toUnsignedLong(0);
        }
    }

    private int saveJustification(Long id, JustificationEntity justificationEntity){
        justificationEntity.setId_staff(id);
        try{
            justificationRepository.save(justificationEntity);
            return 0;
        }catch (Exception e){
            System.out.println(e);
            return 1;
        }

    }

    public int uploadJustifive(String rut, JustificationEntity justificationEntity){
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
