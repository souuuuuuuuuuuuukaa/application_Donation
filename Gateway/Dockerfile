# Utiliser l'image officielle de Java
FROM openjdk:17-jdk
#pour ne pas enregestrer les donner à l'interieur de conteneur (si la machine demarre il ecrit dans le fichier /tmp de la machine
VOLUME /tmp
# Ajouter le JAR généré par Spring Boot
COPY target/*.jar App.jar

# Démarrer l'application Spring Boot
ENTRYPOINT ["java", "-jar", "App.jar"]
