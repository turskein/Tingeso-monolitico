package backend.services;


import backend.entities.ExtraHoursEntity;
import backend.entities.JustificationEntity;
import backend.repositories.ExtraHoursRepositoty;
import backend.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadExtraHoursService {
    @Autowired
    StaffRepository staffRepository;

    @Autowired
    ExtraHoursRepositoty extraHoursRepositoty;

    private Long getIdByRut(String rut){
        try {
            return staffRepository.findByRut(rut).get(0).getId_staff();
        }catch (Exception e){
            System.out.println(e);
            return Integer.toUnsignedLong(0);
        }
    }

    private void saveJustification(Long id, ExtraHoursEntity extraHoursEntity){
        extraHoursEntity.setId_staff(id);
        extraHoursRepositoty.save(extraHoursEntity);
    }

    public int uploadExtraHours(String rut, ExtraHoursEntity extraHoursEntity){
        Long idStaff = getIdByRut(rut);
        if(idStaff == Integer.toUnsignedLong(0)){
            return 1;
        }
        saveJustification(idStaff, extraHoursEntity);
        return 0;
    }

}
