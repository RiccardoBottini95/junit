package listadinamica;

import java.util.Arrays;

public class ListaInteger {

    Integer[] mem;

    /**
     * Costruttore Lista di interi wrapper
     */
    public ListaInteger() {
        this.mem = new Integer[0];
    }

    /**
     * Ritorna tutto l'array
     *
     * @return
     */
    public Integer[] getAll() {
        return this.mem;
    }

    /**
     * Ritorna elemento nella posizione desiderata
     *
     * @param indice posizione dell'elemento
     * @return elemento
     */
    public Integer getElement(int indice) {
        if (indice >= 0 && indice < this.mem.length) {
            return this.mem[indice];
        }//end if
        //todo aggiungere exception
        return null;
    }

    /**
     * Ritorna la dimensione dell'array
     *
     * @return dimensione array
     */
    public int getSize() {
        return this.mem.length;
    }

    /**
     * Aggiunge elemento in coda creando un nuovo array
     * lungo quanto quello vecchio + 1
     *
     * @param elemento valore che si intende aggiungere
     */
    public void addElement(int elemento) {
        Integer[] tmp = new Integer[this.mem.length + 1];
        for (int i = 0; i < this.mem.length; i++) {
            tmp[i] = this.mem[i];
        }//end for
        tmp[this.mem.length] = elemento;
        this.mem = tmp;
    }

    /**
     * Rimuove elemento nella posizione desiderata
     * creando un nuovo array lungo quanto quello vecchio - 1
     *
     * @param posizione posizione dell'elemento da rimuovere
     */
    public void removeElement(int posizione) {
        Integer[] tmp = new Integer[this.mem.length - 1];
        for (int i = 0; i < mem.length; i++) {
            if (i == posizione) {
                continue;
            }
            if (i < posizione) {
                tmp[i] = this.mem[i];
            }
            if (i > posizione) {
                tmp[i - 1] = this.mem[i];
            }
        }//end for
        this.mem = tmp;
    }

    /**
     * Stampa l'array utilizzando getAll
     *
     * @return String contenente l'array
     */
    @Override
    public String toString() {
        return Arrays.toString(getAll());
    }


    /**
     * Stampa tutta la lista utilizzando ciclo for
     * e concatenando gli elementi
     *
     * @return Stringa contenente tutti gli elementi dell'array
     */
    /*
    @Override
    public String toString() {
        String out = "ListaInteger: [";
        for (int i = 0; i < this.mem.length; i++) {
            out += this.mem[i];
            if (i != this.mem.length - 1) {
                out += ",";
            }//end if
        }//end for
        out += "]";
        return out;
    }

     */

    /**
     * Trova elemento minimo nell'array
     *
     * @return minimo
     */
    public Integer trovaMinimo() {
        if (this.mem.length == 0) {
            return null;
        }
        Integer minimo = this.mem[0];
        for (Integer elemento : this.mem) {
            if (elemento < minimo) {
                minimo = elemento;
            }
        }
        return minimo;
    }

    /**
     * Trova elemento massimo nell'array
     *
     * @return massimo
     */
    public Integer trovaMassimo() {
        if(this.mem.length == 0){
            return null;
        }
        int massimo = this.mem[0];
        for (Integer elemento : this.mem) {
            if (elemento > massimo) {
                massimo = elemento;
            }
        }
        return massimo;
    }

    /**
     * Ordina crescente con Bubble Sort
     *
     * @return array ordinato crescente
     */
    public Integer[] ordinaCresc() {
        boolean scambio = true;
        while (scambio) {
            scambio = false;
            for (int i = 0; i < this.mem.length - 1; i++) {
                if (mem[i] > mem[i + 1]) {
                    Integer tmp = mem[i];
                    mem[i] = mem[i + 1];
                    mem[i + 1] = tmp;
                    scambio = true;
                }
            }
        }
        return mem;
    }

    /**
     * Ordina decrescente con Bubble Sort
     *
     * @return
     */
    public Integer[] ordinaDesc() {
        boolean scambio = true;
        while (scambio) {
            scambio = false;
            for (int i = 0; i < this.mem.length - 1; i++) {
                if (mem[i] < mem[i + 1]) {
                    Integer tmp = mem[i];
                    mem[i] = mem[i + 1];
                    mem[i + 1] = tmp;
                    scambio = true;
                }
            }
        }
        return mem;
    }

    /**
     * Conto occorrenze di un valore nell'array
     *
     * @param valore valore da trovare
     * @return numero occorrenze
     */
    public int contaOccorrenze(int valore) {
        int contaOccorrenza = 0;
        for (int elemento : this.mem) {
            if (elemento == valore) {
                contaOccorrenza++;
            }
        }
        return contaOccorrenza;
    }

    /**
     * Trova indice prima corrispondenza con il valore cercato
     *
     * @param valore numero che si vuole cercare
     * @return posizione valore cercato
     */
    public int trovaIndice(int valore) {
        for (int i = 0; i < this.mem.length; i++) {
            if (this.mem[i].equals(valore)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Restituisce elementi maggiori o maggiori e uguali del valore inserito
     *
     * @param soglia per indicare se > o >=
     * @param valore valore soglia
     * @return
     */
    public Integer[] getElementoSopraSoglia(boolean soglia, int valore) {
        ListaInteger risultato = new ListaInteger();
        if (soglia) {
            for (int elemento : this.mem) {
                if (elemento >= valore) {
                    risultato.addElement(elemento);
                }
            }
        } else {
            for (int elemento : this.mem) {
                if (elemento > valore) {
                    risultato.addElement(elemento);
                }
            }
        }
        return risultato.getAll();
    }

    /**
     * Restituisce gli elementi minori o minori e uguali del valore inserito
     *
     * @param soglia per indicare se si vuole fare < o <=
     * @param valore valore soglia
     * @return
     */
    public Integer[] getElementoSottoSoglia(boolean soglia, int valore) {
        ListaInteger risultato = new ListaInteger();
        if (soglia) {
            for (int elemento : this.mem) {
                if (elemento <= valore) {
                    risultato.addElement(elemento);
                }
            }
        } else {
            for (int elemento : this.mem) {
                if (elemento < valore) {
                    risultato.addElement(elemento);
                }
            }
        }
        return risultato.getAll();
    }


    /**
     * Inverte elementi dell'array
     *
     * @return
     */
    public Integer[] inverti() {
        for (int i = 0; i < this.mem.length / 2; i++) {
            Integer tmp = this.mem[i];
            this.mem[i] = this.mem[this.mem.length - 1 - i];
            this.mem[this.mem.length - 1 - i] = tmp;
        }
        return this.mem;
    }
}
