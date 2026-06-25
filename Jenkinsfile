pipeline {
agent any

stages {

    stage('Build em Container Docker') {
        steps {
            bat '''
            docker run --rm ^
            -v "%cd%":/app ^
            -w /app ^
            maven:3.9-eclipse-temurin-17 ^
            mvn clean compile
            '''
        }
    }

    stage('Testes em Outro Container Docker') {
        steps {
            bat '''
            docker run --rm ^
            -v "%cd%":/app ^
            -w /app ^
            maven:3.9-eclipse-temurin-17 ^
            mvn test
            '''
        }
    }
}

post {

    success {
        echo 'Tudo executado com sucesso!'
    }

    unstable {
        echo 'Build instável!'
    }

    failure {
        echo 'Falha no build!'
    }
}


}
