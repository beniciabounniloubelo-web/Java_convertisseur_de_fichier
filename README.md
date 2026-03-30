# FileConverter — Convertisseur de fichiers vers le format PIF

Application de conversion de fichiers vers un format personnalisé PIF.  
**Contenu :** import de fichiers · conversion vers le format PIF · export du résultat  
**Stack :** Java

> Projet académique — BUT Informatique



# Commandes du Makefile

Ce document decrit les principales commandes disponibles dans le `Makefile` du projet **Primitive Image Format**.

## Compilation

### Compiler tout le projet et generer le JAR
```bash
make all
```
- Cree le dossier `build/`
- Compile toutes les classes Java
- Genere le fichier `primitiveimageformat.jar`
- Classe principale par defaut : `PrintImage`

### Initialiser le dossier de build
```bash
make init
```
Cree le dossier `build/` s'il n'existe pas.

## Execution

### Executer PrintImage (depuis les classes compilees)
```bash
make exec_printimage args="..."
```

### Executer ShowImage (depuis les classes compilees)
```bash
make exec_showimage args="..."
```

### Executer le JAR (PrintImage)
```bash
make run args="..."
```

### Executer ShowImage depuis le JAR
```bash
make run_showimage
```

### Executer PrintImage depuis le JAR
```bash
make run_printimage
```

## Nettoyage

### Supprimer les fichiers generes
```bash
make clean
```
Supprime :
- le dossier `build/`
- le fichier JAR
- la documentation `doc/`

## Documentation

### Generer la Javadoc
```bash
make javadoc
```

### Ouvrir la Javadoc
```bash
make seedoc
```

## Notes

- Les sources Java se trouvent dans `src/rootfolder`
- Les fichiers compiles sont places dans `build/rootfolder`
- Les options de compilation utilisent `-Xlint:unchecked`
