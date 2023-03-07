# Doctor Boooking App

##  Frameworks and Language Used

    -> Java 19
    -> Spring Boot
    -> MySQl

 
# Data Flow

### Controller

- #### DoctorController
    -> Handles the CRUD operations of Doctor model.

- #### PatientController
    ->Handles the CRUD operatons of Patient model.


### Service

- #### DoctorService
    -> All the business logic for Doctor model will be implemented by DoctorService.
- #### PatientService
    ->  All the business logic for Patient model will be implemented by PatientService.




# Repository

- ### IDoctorRepository
    -> It extents JpaRepository and contains all the CRUD operations for the Doctor Model.

- ### IPatientRepository
    -> It extents JpaRepository and contains all the CRUD operations for the Patient Model.

# Database Design 
    -> There are two Entiries in this application - Doctor and Patient.
   

# Data Structure Used
    -> ArrayList.
    -> Java classes and Interfaces.
# Project Summary 
    -> This Doctor Booking application by using this application the patients can register their data.
# Server Used
    -> http:localhost:8080/(required url);
    -> h2-console for mapping the database- http://localhost:8080/h2-console
