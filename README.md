# SparingConnect-microservices

## Vue d'ensemble

SparingConnect-microservices est un projet basé sur une architecture microservices, utilisant Docker et Spring Boot pour gérer divers services de manière indépendante.

## Services

- **Eureka Server** : Découverte et enregistrement des services
- **API Gateway** : Routage des requêtes
- **gestioMessage** : Gestion des messages
- **gestionProfil** : Gestion des profils utilisateurs
- **gestionUtilisateur** : Gestion des utilisateurs

## Installation

1. **Prérequis** : Docker, Docker Compose
2. **Commandes** :

   ```bash
   # Clonez le dépôt
   git clone <url-du-dépôt>
   
   # Accédez au répertoire du projet
   cd <répertoire-du-projet>
   
   # Démarrez les services
   docker-compose up --build

Licence
Licence MIT - voir le fichier LICENSE.
