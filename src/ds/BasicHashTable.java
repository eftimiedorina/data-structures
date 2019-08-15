package ds;

public class BasicHashTable<X, Y> {

    private HashEntry[] data;
    private int capacity;
    private int size;

    public BasicHashTable(int tableSize) {
        this.capacity = tableSize;
        this.data = new HashEntry[this.capacity];
        this.size = 0;
    }

    public Y get(X key) {
        int hash = calculateHash(key);

        // if we don't have anything for the given key, just return null
        if (data[hash] == null) {
            return null;
        }
        // otherwise get the hashEntry for the key and return its value
        else {
            return (Y) data[hash].getValue();
        }

    }

    public void put(X key, Y value) {
        int hash = calculateHash(key);

        data[hash] = new HashEntry<X, Y>(key, value);
        size++;

    }

    public Y delete(X key) {
        // first get the value for this key so it can be returned
        Y value = get(key);

        // clear out the hashtable slot for the key and return the removed value
        if (value != null) {
            int hash = calculateHash(key);
            data[hash] = null;
            size--;
            hash = (hash + 1) % this.capacity;

            // if the next slot isn't empty we should re add it so we can keep the hash algo clean
            while (data[hash] != null) {
                HashEntry he = data[hash];
                data[hash] = null;
                put((X) he.getKey(), (Y) he.getValue());
                // we repositioned the hash item and didn't really add a new one so back off the size
                size--;
                hash = (hash + 1) % this.capacity;
            }
        }

        return value;

    }

    public boolean hasKey(X key) {
        int hash = calculateHash(key);

        // if we don't have anything for the given key, we can just return false
        if (data[hash] == null) {
            return false;
        }

        // otherwise get the hash entry for the key and see if it matches the given key
        else {
            if (data[hash].getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasValue(Y value) {
        // loop through all of the hash entries
        for (int i = 0; i < this.capacity; i++) {
            HashEntry entry = data[i];

            //if this hash entry isn't null and the value equals the one passed in, the hashtable has this alue
            if (entry != null && entry.getValue().equals(value))
                return true;
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public int calculateHash(X key) {
        int hash = (key.hashCode() % this.capacity);
        // this is necessary to deal with collisions
        while (data[hash] != null && !data[hash].getKey().equals(key)) {
            hash = (hash + 1) % this.capacity;
        }
        return hash;
    }

    public class HashEntry<X, y> {
        private X key;
        private Y value;

        public HashEntry(X key, Y value) {
            this.key = key;
            this.value = value;
        }

        public X getKey() {
            return key;
        }

        public void setKey(X key) {
            this.key = key;
        }

        public Y getValue() {
            return value;
        }

        public void setValue(Y value) {
            this.value = value;
        }
    }

}
