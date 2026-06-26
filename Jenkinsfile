pipeline {
    agent any

    stages {
        stage('Build em Container Docker') {
            steps {
                // Comando em uma linha só para evitar que o CMD fique aguardando input
                bat 'docker run --rm -v "%cd%":/app -v "%USERPROFILE%\\.m2":/root/.m2 -w /app maven:3.9-eclipse-temurin-17 mvn clean compile'
            }
        }

        stage('Testes em Outro Container Docker') {
            steps {
                bat 'docker run --rm -v "%cd%":/app -v "%USERPROFILE%\\.m2":/root/.m2 -w /app maven:3.9-eclipse-temurin-17 mvn test'
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