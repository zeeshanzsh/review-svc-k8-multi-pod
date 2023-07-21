![K8s-multiple-node](https://github.com/zeeshanzsh/review-svc-k8-multi-pod/assets/30749560/b1a06122-a211-478a-a2be-8d5899e4db90)

# Deploy POD: 1 
**Step 1:**

`kubectl apply -f k8s-mongodb-deployment.yaml`

**Step 2:**

After applying the YAML, you can check the status of your MongoDB Deployment, Service, and PVC by running:
```agsl
kubectl get deployment mongo-deployment
kubectl get service mongo-service
kubectl get pvc mongo-pvc
```
# Deploy POD: 2
**Step 1:**

Build the Docker image for the review app.
```
docker build -t review-app:<version> .
docker build -t review-app:1.0.1 .
docker images
```
**Step 2:**

Deploy the review app to deployment and service object

```agsl
kubectl apply -f k8s-review-app-deployment.yaml
kubectl get pods
kubectl describe pods <pod-name>
kubectl logs <pod-name>
```


# Access the Node from internet

**step 1:**

```agsl
kubectl get all
get the port of node of the app 
Ex:
service/review          NodePort    10.100.29.130   <none>        8080:30060/TCP   24m
```
**Health API**
`GET URL: http://localhost:30060`

**Get all the reviews**
`GET URL: http://localhost:30060/reviews`

**POST the review**
```agsl
curl --location 'http://localhost:30060/review' \
--header 'Content-Type: application/json' \
--data '{
    "name":"TAJ Hotel",
    "reviewComments":"Amazing Tasty Food and Hotel has the  Great Ambiance"
}'
```

**curl cmd to get all the reviews**
```agsl
curl --location --request GET 'http://localhost:30060/reviews' \
--header 'Content-Type: application/json' \
--data '{
    "name":"TAJ Hotel",
    "reviewComments":"Amazing Tasty Food and Hotel has the  Great Ambiance"
}'
```
