buildgradle:
	docker run --rm -u root -v "$PWD":/home/gradle/project -w /home/gradle/project gradle:jdk8 gradle build

buildgradlelocal:
	gradle build

buildimage:
	[ -f ./build/libs/planets-0.0.1-SNAPSHOT.jar ] && docker build -t planets-java . || echo "Please, make the build first"

drun:
	docker-compose up -d --remove-orphans

dstop:
	docker-compose down

runmongo:
	docker-compose up -d --remove-orphans mongo-planets

jrun:
	[ -f ./build/libs/planets-0.0.1-SNAPSHOT.jar ] && java -jar ./build/libs/planets-0.0.1-SNAPSHOT.jar || echo "Please, make the build first"