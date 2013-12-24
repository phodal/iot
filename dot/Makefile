default:
	@echo 'Generate system structure frame'
all: 
	dot struct.dot -Tpng -o struct.png

clean:
	rm -rf *.png

%.png: %.dot
	dot $< -Tpng -o $@

graphs: $(patsubst %,$(GRAPHDIR)/%.png, Complex Simple IFileReader McCabe)

