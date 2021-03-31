# football-manager


## Bitnami

### Install with Helm

```helm install postgresql --set postgresqlUsername=${DB_USER},postgresqlPassword={DB_PASSWORD},postgresqlDatabase={DB_NAME} bitnami/postgresql```


### Delete 

helm delete postgresql


### Issues
If you want to recreate a DB with a different DB name, pvc should be deleted first. 
kubectl get pvc -l data-postgresql-postgresql-0
kubectl delete pvc -l data-postgresql-postgresql-0
