package backend;

import backend.entities.CategoryEntity;
import backend.entities.ExtraHoursEntity;
import backend.entities.JustificationEntity;
import backend.entities.StaffEntity;
import backend.repositories.*;
import backend.services.UploadDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FillDatabase {
    @Autowired
    UploadDataService uploadDataService;

    @Autowired
    TimeStampRepository timeStampRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    StaffRepository staffRepository;
    @Autowired
    JustificationRepository justificationRepository;

    @Autowired
    ExtraHoursRepository extraHoursRepository;

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public Date makeDate(int day, int month, int year){
        try{
            return formatter.parse(year+"-"+month+"-"+day);
        }catch (ParseException e){
        }
        return null;
    }

    public void uploadTimestamps(){
        String allInfo = new String();
        try (BufferedReader reader = new BufferedReader(new FileReader(
                "src/test/resources/timestamps.txt"))){
            String line = reader.readLine();
            while (line != null) {
                allInfo = allInfo + line + "\n";
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
        }

        uploadDataService.uploadTimeStamps(allInfo);
    }

    public void deleteTimestamps(){
        timeStampRepository.deleteAll();
    }

    public void uploadCategories(){
        CategoryEntity categoryA = new CategoryEntity();
        categoryA.setCategory("A");
        CategoryEntity categoryB = new CategoryEntity();
        categoryB.setCategory("B");
        CategoryEntity categoryC = new CategoryEntity();
        categoryC.setCategory("C");

        categoryRepository.save(categoryA);
        categoryRepository.save(categoryB);
        categoryRepository.save(categoryC);
    }

    public void deleteCategories(){
        categoryRepository.deleteAll();
    }

    public void uploadStaff(){
        CategoryEntity catA = categoryRepository.findByCategory("A").get(0);
        CategoryEntity catB = categoryRepository.findByCategory("B").get(0);
        CategoryEntity catC = categoryRepository.findByCategory("C").get(0);

        StaffEntity worker1 = new StaffEntity();
        worker1.setName("Alex");
        worker1.setLastname("Pacheco");
        worker1.setRut("23.537.297-5");
        worker1.setIngress(makeDate(10,9,2000));
        worker1.setBirthday(makeDate(13,12,2000));
        worker1.setIdCategory(catA.getId());
        StaffEntity worker2 = new StaffEntity();
        worker2.setName("Francisco");
        worker2.setLastname("Salfate");
        worker2.setRut("20.847.783-8");
        worker2.setIngress(makeDate(10,1,2017));
        worker2.setBirthday(makeDate(28,9,2001));
        worker2.setIdCategory(catB.getId());
        StaffEntity worker3 = new StaffEntity();
        worker3.setName("Gaspar");
        worker3.setLastname("Catalan");
        worker3.setRut("18.292.684-1");
        worker3.setIngress(makeDate(29,6,2020));
        worker3.setBirthday(makeDate(28,9,2001));
        worker3.setIdCategory(catC.getId());

        staffRepository.save(worker1);
        staffRepository.save(worker2);
        staffRepository.save(worker3);
    }

    public void deleteStaff(){
        staffRepository.deleteAll();
    }


    public void uploadJustifications(){
        StaffEntity gaspitas = staffRepository.findByRut("18.292.684-1").get(0);

        JustificationEntity firstJustification = new JustificationEntity();
        firstJustification.setIdStaff(gaspitas.getIdStaff());
        firstJustification.setDate(makeDate(6,9,2022));

        JustificationEntity secondJustification = new JustificationEntity();
        secondJustification.setIdStaff(gaspitas.getIdStaff());
        secondJustification.setDate(makeDate(7,9,2022));

        justificationRepository.save(firstJustification);
        justificationRepository.save(secondJustification);
    }

    public void deleteJustifications(){
        justificationRepository.deleteAll();
    }

    public void uploadExtrahours(){
        StaffEntity panchito = staffRepository.findByRut("20.847.783-8").get(0);

        ExtraHoursEntity firstExtraHours = new ExtraHoursEntity();
        firstExtraHours.setIdStaff(panchito.getIdStaff());
        firstExtraHours.setDate(makeDate(7,9,2022));
        firstExtraHours.setAmount(4);

        ExtraHoursEntity secondExtraHours = new ExtraHoursEntity();
        secondExtraHours.setIdStaff(panchito.getIdStaff());
        secondExtraHours.setDate(makeDate(9,9,2022));
        secondExtraHours.setAmount(2);
    }

    public void deleteExtraHours(){
        extraHoursRepository.deleteAll();
    }

}
