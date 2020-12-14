####Compilar y Publicar Imagen

mvn clean install &&
docker build -t="users.azurecr.io/users-prueba:0.0.1" --build-arg artifact_id=vpd-batch-filetransfer --build-arg artifact_version=0.0.1 . &&
docker push userdev01.azurecr.io/vpd-users:0.0.1

####Eliminar Configmap  ( si existiese )
kubectl delete configmap users-properties

kubectl create configmap users-properties --from-file=config-dev.properties

####Eliminar Secret ( si existiese )
kubectl delete secret config-sensibles-users

####Crear Secret 
kubectl create secret generic config-sensibles-users --from-file=config-sensibles-dev.properties
