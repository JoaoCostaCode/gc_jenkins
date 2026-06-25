pipeline {
agent any

stages {

    stage('Verificar Docker') {
        steps {
            bat 'docker --version'
        }
    }

    stage('Build em Container Docker') {
        steps {
            bat 'docker run --rm maven:3.9-eclipse-temurin-17 mvn --version'
        }
    }

    stage('Testes') {
        steps {
            bat 'echo Testes funcionando'
        }
    }
}


}
