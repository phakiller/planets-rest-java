buildgradle:
	docker run --rm -u root -v "$PWD":/home/gradle/project -w /home/gradle/project gradle:jdk8 gradle build

buildgradlelocal:
	gradle build

buildimage:
	docker build -t planets-java .

drun:
	[ -f ./build/libs/planets-0.0.1-SNAPSHOT.jar ] && docker-compose up -d --remove-orphans || echo "Please, make the build first"

dstop:
	docker-compose down

runmongo:
	docker-compose up -d --remove-orphans mongo-planets

jrun:
	[ -f ./build/libs/planets-0.0.1-SNAPSHOT.jar ] && java -jar ./build/libs/planets-0.0.1-SNAPSHOT.jar || echo "Please, make the build first"