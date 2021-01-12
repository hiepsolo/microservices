Auth Microservice

**BUILD**
Run steps:
- mvn -Dmaven.repo.local=./repository clean package
- tar cf repository.tar.gz ./repository
- docker build -t g8h9/auth . && docker push g8h9/auth