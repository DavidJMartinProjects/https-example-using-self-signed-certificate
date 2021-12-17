# Securing a web app on k8 with SSL

## Step 1.
Create simple web app with Springboot & expose an entrypoint

## Step 2.
Create a DockerFile and K8 namespace/deployment/service files

## Step 3.
Install an Nginx Ingress to the cluster

## Step 4.
Generate key and certificate using openssL
 - (use ubuntu if using Windows OS)

    ```
    openssl req -x509 -newkey rsa:4096 -sha256 -nodes -keyout tls.key -out tls.crt -subj "/CN=my-example.com" -days 365
    ```



## Step 5.
Generate a k8 Secret based on the key and cert

    ```
    kubectl create secret tls example-com-tld --cert=tls.crt --key=tls.key -o yaml > example-com.tls.secret.yml
    ```

## Step 6.
Create a K8 Ingress and add the secret details under the spec section

    ```
    spec:
    tls:
    - secretName: example-service-tls
        hosts:
        - my-example.com
    ```

## Step 7.
Verify that SSL is now applied to your web app