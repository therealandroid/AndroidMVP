# Welcome 

to MVP Android Architecture

Hi! This is just a simple architecture for Android Applications using **MVP**


----------


Technologies and Frameworks

* **Dagger 2**
* **RxAndroid**
* **Realm**
* **MVP**


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
