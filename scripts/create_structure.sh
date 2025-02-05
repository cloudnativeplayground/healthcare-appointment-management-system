#!/bin/bash

mkdir -p healthcare-appointment-management-system/src/main/java/com/cloudnativeplayground/healthcare/{controller,service,repository,model,config,dto,exception,security}
mkdir -p healthcare-appointment-management-system/src/main/resources/{static,templates}
mkdir -p healthcare-appointment-management-system/src/test/java/com/cloudnativeplayground/healthcare/{controller,service,repository}
mkdir -p healthcare-appointment-management-system/deployment/k8s
mkdir -p healthcare-appointment-management-system/scripts
mkdir -p healthcare-appointment-management-system/docs

touch healthcare-appointment-management-system/src/main/resources/application.yml
touch healthcare-appointment-management-system/src/main/resources/messages.properties
touch healthcare-appointment-management-system/build.gradle
touch healthcare-appointment-management-system/settings.gradle
touch healthcare-appointment-management-system/Dockerfile
touch healthcare-appointment-management-system/README.md
touch healthcare-appointment-management-system/.gitignore
touch healthcare-appointment-management-system/LICENSE
touch healthcare-appointment-management-system/deployment/k8s/deployment.yaml
touch healthcare-appointment-management-system/deployment/k8s/service.yaml
touch healthcare-appointment-management-system/deployment/k8s/ingress.yaml
touch healthcare-appointment-management-system/scripts/create_structure.sh
touch healthcare-appointment-management-system/scripts/create_structure.bat
touch healthcare-appointment-management-system/docs/REST_API_Documentation.md
touch healthcare-appointment-management-system/docs/Actuator_Endpoints.md

echo "Folder structure and files created successfully!"
