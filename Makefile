SRC = src
BUILD = build
PKG = rootfolder
JAR_NAME = primitiveimageformat.jar

# Classes arbre--------------------------------------------------------------
ARBRE_AFFICHERTABCODE_CLASS = $(BUILD)/$(PKG)/AfficherTabCode.class
ARBRE_NOEUD_CLASS = $(BUILD)/$(PKG)/Noeud.class
ARBRE_PARCOURSARBRE_CLASS = $(BUILD)/$(PKG)/ParcoursArbre.class
ARBRE_ARBREHUFFMAN_CLASS = $(BUILD)/$(PKG)/ArbreHuffman.class

# Classes canonique--------------------------------------------------------------
CANONIQUE_AFFICHERTABCA_CLASS = $(BUILD)/$(PKG)/AfficherTabCa.class
CANONIQUE_CODELENGTHSORTER_CLASS = $(BUILD)/$(PKG)/CodeLengthSorter.class
CANONIQUE_CODELENGTHSORTERBIS_CLASS = $(BUILD)/$(PKG)/CodeLengthSorterBis.class
CANONIQUE_TABCAENTREE_CLASS = $(BUILD)/$(PKG)/TabCaEntree.class
CANONIQUE_TABCAFINALE_CLASS = $(BUILD)/$(PKG)/TabCaFinale.class
CANONIQUE_TABCAFINALEBIS_CLASS = $(BUILD)/$(PKG)/TabCaFinaleBis.class

# Classes frequence--------------------------------------------------------------
FREQ_AFFICHERTABFREQ_CLASS = $(BUILD)/$(PKG)/AfficherTabFreq.class
FREQ_TABFREQ_CLASS = $(BUILD)/$(PKG)/TabFreq.class
FREQ_TROISCOULEURS_CLASS = $(BUILD)/$(PKG)/TroisCouleurs.class

# Le reste des classes--------------------------------------------------------------
CHARGEMENTIMAGE_CLASS = $(BUILD)/$(PKG)/ChargementImage.class
MCANONIQUE_CLASS = $(BUILD)/$(PKG)/MCanonique.class
MCANONIQUEBIS_CLASS = $(BUILD)/$(PKG)/MCanoniqueBis.class
MHUFFMAN_CLASS = $(BUILD)/$(PKG)/MHuffman.class
PIFCREATOR_CLASS = $(BUILD)/$(PKG)/PifCreator.class
PIFREADER_CLASS = $(BUILD)/$(PKG)/PifReader.class
PIXELSWRITER_CLASS = $(BUILD)/$(PKG)/PixelsWriter.class
PRINTIMAGE_CLASS = $(BUILD)/$(PKG)/PrintImage.class
SHOWIMAGE_CLASS = $(BUILD)/$(PKG)/ShowImage.class
TABCANOWRITER_CLASS = $(BUILD)/$(PKG)/TabCanoWriter.class
CHOISIRETCREERPIF_CLASS = $(BUILD)/$(PKG)/ChoisirEtCreerPif.class

# Classes principales--------------------------------------------------------------
MAIN1_CLASS_NAME = $(BUILD)/$(PKG)/PrintImage.class
MAIN2_CLASS_NAME = $(BUILD)/$(PKG)/ShowImage.class

# Sources arbre--------------------------------------------------------------
ARBRE_AFFICHERTABCODE_JAVA = $(SRC)/$(PKG)/AfficherTabCode.java
ARBRE_NOEUD_JAVA = $(SRC)/$(PKG)/Noeud.java
ARBRE_PARCOURSARBRE_JAVA = $(SRC)/$(PKG)/ParcoursArbre.java
ARBRE_ARBREHUFFMAN_JAVA = $(SRC)/$(PKG)/ArbreHuffman.java

# Sources canonique--------------------------------------------------------------
CANONIQUE_AFFICHERTABCA_JAVA = $(SRC)/$(PKG)/AfficherTabCa.java
CANONIQUE_CODELENGTHSORTER_JAVA = $(SRC)/$(PKG)/CodeLengthSorter.java
CANONIQUE_CODELENGTHSORTERBIS_JAVA =$(SRC)/$(PKG)/CodeLengthSorterBis.java
CANONIQUE_TABCAENTREE_JAVA = $(SRC)/$(PKG)/TabCaEntree.java
CANONIQUE_TABCAFINALE_JAVA = $(SRC)/$(PKG)/TabCaFinale.java
CANONIQUE_TABCAFINALEBIS_JAVA = $(SRC)/$(PKG)/TabCaFinaleBis.java

# Sources frequence--------------------------------------------------------------
FREQ_AFFICHERTABFREQ_JAVA = $(SRC)/$(PKG)/AfficherTabFreq.java
FREQ_TABFREQ_JAVA = $(SRC)/$(PKG)/TabFreq.java
FREQ_TROISCOULEURS_JAVA = $(SRC)/$(PKG)/TroisCouleurs.java

# Le reste des sources--------------------------------------------------------------
CHARGEMENTIMAGE_JAVA = $(SRC)/$(PKG)/ChargementImage.java
MCANONIQUE_JAVA = $(SRC)/$(PKG)/MCanonique.java
MCANONIQUEBIS_JAVA = $(SRC)/$(PKG)/MCanoniqueBis.java
MHUFFMAN_JAVA = $(SRC)/$(PKG)/MHuffman.java
PIFCREATOR_JAVA = $(SRC)/$(PKG)/PifCreator.java
PIFREADER_JAVA = $(SRC)/$(PKG)/PifReader.java
PIXELSWRITER_JAVA = $(SRC)/$(PKG)/PixelsWriter.java
TABCANOWRITER_JAVA = $(SRC)/$(PKG)/TabCanoWriter.java
CHOISIRETCREERPIF_JAVA = $(SRC)/$(PKG)/ChoisirEtCreerPif.java

# Commande principale----------------------------------------------------------------
all: init $(MAIN1_CLASS_NAME) $(MAIN2_CLASS_NAME)
	jar cvfe $(JAR_NAME) $(PKG).PrintImage -C $(BUILD) . 

# Création dossier build----------------------------------------------------------------
init:
	@mkdir -p $(BUILD)

# INDEPENDANT---------------------------------------------------------------
# ---- Compilation dossier arbre ----
$(ARBRE_AFFICHERTABCODE_CLASS): $(ARBRE_AFFICHERTABCODE_JAVA)
	@echo "Compilation de AfficherTabCode"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(ARBRE_AFFICHERTABCODE_JAVA)

$(ARBRE_NOEUD_CLASS): $(ARBRE_NOEUD_JAVA)
	@echo "Compilation de Noeud"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(ARBRE_NOEUD_JAVA)

# ---- Compilation dossier canonique ----
$(CANONIQUE_AFFICHERTABCA_CLASS): $(CANONIQUE_AFFICHERTABCA_JAVA)
	@echo "Compilation de AfficherTabCa"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(CANONIQUE_AFFICHERTABCA_JAVA)

$(CANONIQUE_TABCAENTREE_CLASS): $(CANONIQUE_TABCAENTREE_JAVA)
	@echo "Compilation de TabCaEntree"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(CANONIQUE_TABCAENTREE_JAVA)

# ---- Compilation dossier frequence ----
$(FREQ_AFFICHERTABFREQ_CLASS): $(FREQ_AFFICHERTABFREQ_JAVA)
	@echo "Compilation de AfficherTabFreq"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(FREQ_AFFICHERTABFREQ_JAVA)

$(FREQ_TROISCOULEURS_CLASS): $(FREQ_TROISCOULEURS_JAVA)
	@echo "Compilation de TroisCouleurs"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(FREQ_TROISCOULEURS_JAVA)

# ---- Compilation du reste ----
$(CHARGEMENTIMAGE_CLASS): $(CHARGEMENTIMAGE_JAVA)
	@echo "Compilation de ChargementImage"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(CHARGEMENTIMAGE_JAVA)

$(PIXELSWRITER_CLASS): $(PIXELSWRITER_JAVA) 
	@echo "Compilation de PixelsWriter"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(PIXELSWRITER_JAVA)

$(TABCANOWRITER_CLASS): $(TABCANOWRITER_JAVA)
	@echo "Compilation de TabCanoWriter"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(TABCANOWRITER_JAVA)

$(CHOISIRETCREERPIF_CLASS): $(CHOISIRETCREERPIF_JAVA)
	@echo "Compilation de ChoisirEtCreerPif"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(CHOISIRETCREERPIF_JAVA)


# DEPENDANT---------------------------------------------------------------
# ---- Compilation dossier arbre ----
$(ARBRE_ARBREHUFFMAN_CLASS): $(ARBRE_ARBREHUFFMAN_JAVA) $(ARBRE_NOEUD_CLASS)
	@echo "Compilation de ArbreHuffman"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(ARBRE_ARBREHUFFMAN_JAVA)

$(ARBRE_PARCOURSARBRE_CLASS): $(ARBRE_PARCOURSARBRE_JAVA) $(ARBRE_NOEUD_CLASS)
	@echo "Compilation de ParcoursArbre"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(ARBRE_PARCOURSARBRE_JAVA)

# ---- Compilation dossier canonique ----
$(CANONIQUE_CODELENGTHSORTER_CLASS): $(CANONIQUE_CODELENGTHSORTER_JAVA) $(CANONIQUE_TABCAENTREE_CLASS)
	@echo "Compilation de CodeLengthSorter"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(CANONIQUE_CODELENGTHSORTER_JAVA)

$(CANONIQUE_CODELENGTHSORTERBIS_CLASS): $(CANONIQUE_CODELENGTHSORTERBIS_JAVA) $(CANONIQUE_TABCAENTREE_CLASS)
	@echo "Compilation de CodeLengthSorterBis"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(CANONIQUE_CODELENGTHSORTERBIS_JAVA)

$(CANONIQUE_TABCAFINALE_CLASS): $(CANONIQUE_TABCAFINALE_JAVA) $(CANONIQUE_TABCAENTREE_CLASS)
	@echo "Compilation de TabCaFinale"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(CANONIQUE_TABCAFINALE_JAVA)

$(CANONIQUE_TABCAFINALEBIS_CLASS): $(CANONIQUE_TABCAFINALEBIS_JAVA) $(CANONIQUE_TABCAENTREE_CLASS)
	@echo "Compilation de TabCaFinaleBis"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(CANONIQUE_TABCAFINALEBIS_JAVA)

# ---- Compilation dossier frequence ----
$(FREQ_TABFREQ_CLASS): $(FREQ_TABFREQ_JAVA) $(FREQ_TROISCOULEURS_CLASS)
	@echo "Compilation de TabFreq"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(FREQ_TABFREQ_JAVA)

# ---- Compilation le reste du dossier ----
$(MCANONIQUE_CLASS): $(MCANONIQUE_JAVA) $(CANONIQUE_TABCAENTREE_CLASS) $(CANONIQUE_TABCAFINALE_CLASS) $(CANONIQUE_CODELENGTHSORTER_CLASS)
	@echo "Compilation de MCanonique"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(MCANONIQUE_JAVA)

$(MCANONIQUEBIS_CLASS): $(MCANONIQUEBIS_JAVA) $(CANONIQUE_TABCAENTREE_CLASS) $(CANONIQUE_TABCAFINALEBIS_CLASS) $(CANONIQUE_CODELENGTHSORTERBIS_CLASS)
	@echo "Compilation de MCanoniqueBis"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(MCANONIQUEBIS_JAVA)

$(MHUFFMAN_CLASS): $(MHUFFMAN_JAVA) $(ARBRE_NOEUD_CLASS) $(ARBRE_PARCOURSARBRE_CLASS) $(ARBRE_ARBREHUFFMAN_CLASS)
	@echo "Compilation de MHuffman"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(MHUFFMAN_JAVA)

$(PIFCREATOR_CLASS): $(PIFCREATOR_JAVA) $(CANONIQUE_AFFICHERTABCA_CLASS) $(CANONIQUE_CODELENGTHSORTER_CLASS) $(CANONIQUE_TABCAENTREE_CLASS) $(CANONIQUE_TABCAFINALE_CLASS) $(MCANONIQUE_CLASS) $(PIXELSWRITER_CLASS) $(TABCANOWRITER_CLASS)
	@echo "Compilation de PifCreator"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(PIFCREATOR_JAVA)

$(PIFREADER_CLASS): $(PIFREADER_JAVA) $(CANONIQUE_AFFICHERTABCA_CLASS) $(CANONIQUE_CODELENGTHSORTERBIS_CLASS) $(CANONIQUE_TABCAENTREE_CLASS) $(CANONIQUE_TABCAFINALEBIS_CLASS) $(MCANONIQUEBIS_CLASS)
	@echo "Compilation de PifReader"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(PIFREADER_JAVA)


MAIN_DEPS1 = \
	$(ARBRE_NOEUD_CLASS) \
	$(ARBRE_AFFICHERTABCODE_CLASS) \
	$(ARBRE_ARBREHUFFMAN_CLASS) \
	$(ARBRE_PARCOURSARBRE_CLASS) \
	$(CANONIQUE_AFFICHERTABCA_CLASS) \
	$(CANONIQUE_TABCAENTREE_CLASS) \
	$(CANONIQUE_CODELENGTHSORTER_CLASS) \
	$(CANONIQUE_TABCAFINALE_CLASS) \
	$(FREQ_AFFICHERTABFREQ_CLASS) \
	$(FREQ_TROISCOULEURS_CLASS) \
	$(FREQ_TABFREQ_CLASS) \
	$(CHARGEMENTIMAGE_CLASS) \
	$(MCANONIQUE_CLASS) \
	$(MHUFFMAN_CLASS) \
	$(TABCANOWRITER_CLASS) \
	$(CHOISIRETCREERPIF_CLASS) \
	$(PIFCREATOR_CLASS) \

MAIN_DEPS2 = \
    $(ARBRE_NOEUD_CLASS) \
	$(ARBRE_AFFICHERTABCODE_CLASS) \
	$(ARBRE_ARBREHUFFMAN_CLASS) \
	$(ARBRE_PARCOURSARBRE_CLASS) \
	$(CANONIQUE_AFFICHERTABCA_CLASS) \
	$(CANONIQUE_TABCAENTREE_CLASS) \
	$(CANONIQUE_CODELENGTHSORTERBIS_CLASS) \
	$(CANONIQUE_TABCAFINALEBIS_CLASS) \
	$(FREQ_AFFICHERTABFREQ_CLASS) \
	$(FREQ_TROISCOULEURS_CLASS) \
	$(FREQ_TABFREQ_CLASS) \
	$(CHARGEMENTIMAGE_CLASS) \
	$(MCANONIQUEBIS_CLASS) \
	$(MHUFFMAN_CLASS) \
	$(PIFREADER_CLASS) \

# Main compilé en dernier----------------------------------------------------------------
$(MAIN1_CLASS_NAME): $(SRC)/$(PKG)/PrintImage.java $(MAIN_DEPS1)
	@echo "Compilation de Main"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(SRC)/$(PKG)/PrintImage.java

$(MAIN2_CLASS_NAME): $(SRC)/$(PKG)/ShowImage.java $(MAIN_DEPS2)
	@echo "Compilation de Main"
	@javac -Xlint:unchecked -d $(BUILD) -cp "$(BUILD)" $(SRC)/$(PKG)/ShowImage.java

# pour enlever le dossier build, le jar et la javadoc--------------------------------------------------------------
clean:
	rm -rf $(BUILD) $(JAR_NAME) doc

# execution--------------------------------------------------------------
exec_showimage: all
	java -cp "$(BUILD)" $(MAIN1_CLASS_NAME) $(args)

exec_printimage: all
	java -cp "$(BUILD)" $(MAIN2_CLASS_NAME) $(args)

# compiler la javadoc--------------------------------------------------------------
javadoc:
	javadoc -d doc -sourcepath $(SRC) -subpackages rootfolder -Xdoclint:none

seedoc: 
	@echo "Ouvrez doc/index.html dans votre navigateur"

# executer le .jar--------------------------------------------------------------
# Execute le JAR avec PrintImage comme classe principale
run: all
	java -jar $(JAR_NAME) $(args)

# Execute ShowImage depuis le JAR (en spécifiant la classe)
run_showimage: all
	java -cp $(JAR_NAME) $(PKG).ShowImage

# Execute PrintImage depuis le JAR (équivalent à `java -jar`)
run_printimage: all
	java -jar $(JAR_NAME)