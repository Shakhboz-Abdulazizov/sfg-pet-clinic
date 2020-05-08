package com.example.petclinicweb.bootstrap;

import com.example.petclinicdata.models.*;
import com.example.petclinicdata.services.OwnerService;
import com.example.petclinicdata.services.PetTypeService;
import com.example.petclinicdata.services.SpecialityService;
import com.example.petclinicdata.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        loadData();


    }

    private void loadData() {
        PetType petType1 = new PetType();
        petType1.setName("dog");
        petType1 = petTypeService.save(petType1);

        PetType petType2 = new PetType();
        petType2.setName("cat");
        petType2 = petTypeService.save(petType2);

        Owner owner1 = new Owner();
        owner1.setFirstName("Shakhboz");
        owner1.setLastName("LastName");
        owner1.setAddress("Shahriobod, 316");
        owner1.setCity("Tashkent");
        owner1.setTelephone("71xxxxxxx");
        ownerService.save(owner1);

        Pet pet1 = new Pet();
        pet1.setName("shDog");
        pet1.setPetType(petType1);
        pet1.setBirthDate(LocalDate.now());
        pet1.setOwner(owner1);
        owner1.getPets().add(pet1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Elbek");
        owner2.setLastName("Mamadaliyev");
        owner2.setAddress("Shahriobod, 316");
        owner2.setCity("Tashkent");
        owner2.setTelephone("71xxxxxxx");
        ownerService.save(owner2);

        Pet pet2 = new Pet();
        pet2.setName("eCat");
        pet2.setPetType(petType2);
        pet2.setBirthDate(LocalDate.now());
        pet2.setOwner(owner2);
        owner2.getPets().add(pet2);

        System.out.println("Owners loaded ....");

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        radiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        surgery = specialityService.save(surgery);


        Vet vet1 = new Vet();
        vet1.setFirstName("John");
        vet1.setLastName("Terry");
        vet1.getSpecialities().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Frank");
        vet2.setLastName("Lampard");
        vet2.getSpecialities().add(surgery);
        vetService.save(vet2);

        System.out.println("Vets loaded...");
    }
}
