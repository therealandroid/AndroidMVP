# Welcome 

to my Android Playground Project

Hi! This is just a simple project that I try to solve some commom problems in android.

----------


Problems I want to solve:

* The best way to separate layers in a MVP Architecture such as the access to Database and API
* The best way to separate UI and Presenter to keep it really simple and uncoupled.
* Another stuffs that I don't know yet

----------


Technologies and Frameworks used

## Update: April 28 2018

* **~~Dagger 2~~**
* **RxAndroid**
* **Realm**
* **MVP**
* **Repository**


----------


Structure

    _ MVP
     |__ Application         " 1 -Singleton files, Config files"
     |__ Domain              " 2- APPLICATION LAYERS"
     |    |__Components      " 3- Dagger 2 components"
     |    |__Mappers         " 4- Application Mappers"
     |    |__Models          " 5- UI/Network based Models"
     |    |__Modules         " 6- Dagger 2 modules"
     |    |__Realm Models    " 7- Realm based models"
     |    |__Repositories    " 8- Database Repository"
     |    |__Services        " 9- Retrofit / Firebase Services "
     |
     |__ Presenter           " 10- Presenter classes"
     |__ View                " 11- UI Classes"
    -
