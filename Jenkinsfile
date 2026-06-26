pipeline {
    agent any

    stages {
        stage('Build em Container Docker') {
            steps {
                // Verifica como o Jenkins está lendo o caminho
                echo "Caminho do WORKSPACE: ${WORKSPACE}"
                echo "Caminho do M2: ${USERPROFILE}\\.m2"
                
                // Força o pull da imagem separadamente para garantir que não é um travamento de download
                bat 'docker pull maven:3.9-eclipse-temurin-17'
                
                // Roda o comando. Note que adicionei aspas simples por fora para garantir a interpolação do .bat
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