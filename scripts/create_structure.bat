@echo off
mkdir healthcare-appointment-management-system\src\main\java\com\cloudnativeplayground\healthcare\controller
mkdir healthcare-appointment-management-system\src\main\java\com\cloudnativeplayground\healthcare\service
mkdir healthcare-appointment-management-system\src\main\java\com\cloudnativeplayground\healthcare\repository
mkdir healthcare-appointment-management-system\src\main\java\com\cloudnativeplayground\healthcare\model
mkdir healthcare-appointment-management-system\src\main\java\com\cloudnativeplayground\healthcare\config
mkdir healthcare-appointment-management-system\src\main\java\com\cloudnativeplayground\healthcare\dto
mkdir healthcare-appointment-management-system\src\main\java\com\cloudnativeplayground\healthcare\exception
mkdir healthcare-appointment-management-system\src\main\java\com\cloudnativeplayground\healthcare\security
mkdir healthcare-appointment-management-system\src\main\resources\static
mkdir healthcare-appointment-management-system\src\main\resources\templates
mkdir healthcare-appointment-management-system\src\test\java\com\cloudnativeplayground\healthcare\controller
mkdir healthcare-appointment-management-system\src\test\java\com\cloudnativeplayground\healthcare\service
mkdir healthcare-appointment-management-system\src\test\java\com\cloudnativeplayground\healthcare\repository
mkdir healthcare-appointment-management-system\deployment\k8s
mkdir healthcare-appointment-management-system\scripts
mkdir healthcare-appointment-management-system\docs

type nul > healthcare-appointment-management-system\src\main\resources\application.yml
type nul > healthcare-appointment-management-system\src\main\resources\messages.properties
type nul > healthcare-appointment-management-system\build.gradle
type nul > healthcare-appointment-management-system\settings.gradle
type nul > healthcare-appointment-management-system\Dockerfile
type nul > healthcare-appointment-management-system\README.md
type nul > healthcare-appointment-management-system\.gitignore
type nul > healthcare-appointment-management-system\LICENSE
type nul > healthcare-appointment-management-system\deployment\k8s\deployment.yaml
type nul > healthcare-appointment-management-system\deployment\k8s\service.yaml
type nul > healthcare-appointment-management-system\deployment\k8s\ingress.yaml
type nul > healthcare-appointment-management-system\scripts\create_structure.sh
type nul > healthcare-appointment-management-system\scripts\create_structure.bat
type nul > healthcare-appointment-management-system\docs\REST_API_Documentation.md
type nul > healthcare-appointment-management-system\docs\Actuator_Endpoints.md

echo Folder structure and files created successfully!
