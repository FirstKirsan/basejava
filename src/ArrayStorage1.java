public class ArrayStorage1 {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) storage[i] = null;
        size = 0;
    }

    public void update(Resume r) {
        boolean resumeExists = false;
        for (int i=0; i<size; i++) {
            if ((storage[i] != null) && (storage[i].uuid.equals(r.uuid))) {
                // update
                resumeExists = true;
                break;
            }
        }
        if (!resumeExists) System.out.println("(UpDate) Error: Resume does not exist.");
    }

    public void save(Resume r) {
        boolean resumeExists = false;
        for (int i=0; i<size; i++) {
            if (storage[i].uuid.equals(r.uuid)) {
                System.out.println("Error: This resume already exists.");
                resumeExists = true;
                break;
            }
        }
        if (!resumeExists) {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if ((storage[i] != null) && (storage[i].uuid.equals(uuid))) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        boolean resumeExists = false;
        for (int i = 0; i < size; i++) {
            if ((storage[i] != null) && (storage[i].uuid.equals(uuid))) {
                size--;
                storage[i] = storage[size];
                storage[size] = null;
                resumeExists = true;
                break;
            }
        }
        if (!resumeExists) System.out.println("(Delete) Error: Resume does not exist.");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        Resume[] st_getAll = new Resume[size];
        System.arraycopy(storage, 0, st_getAll, 0, size);
        return st_getAll;
    }

    public int size() {
        return size;
    }
}