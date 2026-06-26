pipeline {
    agent {
        node {
            // Força o Jenkins a rodar o projeto fora da pasta com caracteres especiais
            customWorkspace 'C:\\JenkinsWorkspace'
        }
    }

    stages {
        stage('Teste de Comunicação') {
            steps {
                echo "Testando se o BAT funciona na nova pasta..."
                bat 'echo Funciona!'
                bat 'docker --version'
            }
        }

        stage('Build em Container Docker') {
            steps {
                bat 'docker pull maven:3.9-eclipse-temurin-17'
                bat 'docker run --rm -v "%WORKSPACE%":/app -v "%USERPROFILE%\\.m2":/root/.m2 -w /app maven:3.9-eclipse-temurin-17 mvn -B clean compile'
            }
        }

        stage('Testes em Outro Container Docker') {
            steps {
                bat 'docker run --rm -v "%WORKSPACE%":/app -v "%USERPROFILE%\\.m2":/root/.m2 -w /app maven:3.9-eclipse-temurin-17 mvn -B test'
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