
                public 
                    //on recupere nom du nv fichier--------------------------
                    if (args.length >= 2){
                        newfichierpif = new File(args[1]);

                        // Ajouter l'extension .pif au besoin
                        if (!newfichierpif.getName().endsWith(".pif")) {
                            newfichierpif = new File(newfichierpif.getAbsolutePath() + ".pif");
                        }
                    } /*else if (args.length >= 1) {
                            JOptionPane.showMessageDialog(frame, "Rentrez en deuxieme argument un nom pour le nouveau fichier");
                    }*/
                    if (newfichierpif == null) {
                        JFileChooser choose = new JFileChooser(new File("."));
                        choose.setDialogTitle("Choisissez l'emplacement du fichier .pif");
                        int res = choose.showSaveDialog(null);
                        if (res == JFileChooser.APPROVE_OPTION) {
                            newfichierpif = choose.getSelectedFile();
                            if (!newfichierpif.getName().endsWith(".pif")) {
                                newfichierpif = new File(newfichierpif.getAbsolutePath() + ".pif");
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "Aucun fichier de sortie choisi");
                            System.exit(0);
                        }
                    }

                    //creation du fichier-------------------------
                    try {
                        if (!newfichierpif.exists()) {
                            newfichierpif.createNewFile();
                            JOptionPane.showMessageDialog(frame, "Fichier cree avec succes !");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Le fichier existe deja");
                        }
                    } catch (IOException exc) {
                        exc.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Erreur lors de la creation du fichier !");
                    }

                    //on rentre dans la conversion la !!
                    PifCreator pifFile= new PifCreator(imgbis, newfichierpif, tableCanoRouge, tableCanoVert, tableCanoBleu);
                    pifFile.ecrirePif();
                    
                    return newfichierpif;