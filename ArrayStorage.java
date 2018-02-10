/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int resNum = 0;

    void clear() {
        storage = new Resume[10000];
    }

    void save(Resume r) {
        storage[resNum] = r;
        resNum++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].uuid.equals(uuid)) return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].uuid.equals(uuid)) storage[i] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int size_st_GA = this.size();
        Resume[] st_getAll = new Resume[size_st_GA];
        int j = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                st_getAll[j] = storage[i];
                j++;
            }
        }

        return st_getAll;
    }

    int size() {
        int size = 0;
        for (int i = 0; i < storage.length; i++) if (storage[i] != null) size++;
        return size;
    }
}
