FROM java:8
EXPOSE 8585
ADD /target/GestionDeStock-0.0.1-SNAPSHOT.jar docker-gestion-commande.jar
ENTRYPOINT ["java","-jar","docker-gestion-commande.jar"]