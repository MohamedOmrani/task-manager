# Étape 1 : builder Angular
FROM node:18-alpine as builder     
# Utilise une image Node.js légère pour builder l application Angular
WORKDIR /app                       
# Définit le dossier de travail à /app dans le conteneur
COPY . .                           
# Copie tous les fichiers de ton projet Angular dans le dossier /app
RUN npm install && npm run build --prod  
# 1. Installe les dépendances Node.js de ton projet
# 2. Compile l'application Angular en mode production (génère le dossier dist/frontend)



# Étape 2 : servir avec NGINX
FROM nginx:alpine                 
# Utilise une image NGINX légère pour servir l'app
COPY --from=builder /app/dist/frontend /usr/share/nginx/html  
# Copie les fichiers compilés Angular (HTML, JS, CSS...) vers le répertoire public de NGINX

EXPOSE 80                         
# Expose le port 80 (celui sur lequel NGINX écoute)
CMD ["nginx", "-g", "daemon off;"]  
# Commande de démarrage par défaut : lance NGINX en mode "foreground"


