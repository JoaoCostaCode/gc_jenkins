pipeline {
agent any

```
stages {

    stage('Build em Container Docker') {
        steps {
            script {
                docker.image('maven:3.9-eclipse-temurin-17').inside {
                    sh 'mvn clean compile'
                }
            }
        }
    }

    stage('Testes em Outro Container Docker') {
        steps {
            script {
                docker.image('maven:3.9-eclipse-temurin-17').inside {
                    sh 'mvn test'
                }
            }
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
```

}
