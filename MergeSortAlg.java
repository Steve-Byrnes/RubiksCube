package renderer.shapes;

public class MergeSortAlg {

    public static void mergeSort(MyPolygon[] polygons, int n, int mouseX, int mouseY, int depth) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        MyPolygon[] l = new MyPolygon[mid];
        MyPolygon[] r = new MyPolygon[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = polygons[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = polygons[i];
        }
        mergeSort(l, mid, mouseX, mouseY, depth);
        mergeSort(r, n - mid, mouseX, mouseY, depth);

        merge(polygons, l, r, mid, n - mid, mouseX, mouseY, depth);
    }

    public static void merge(MyPolygon[] polygons, MyPolygon[] l, MyPolygon[] r,
                      int left, int right, int mouseX, int mouseY, int depth) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i].distanceFromCamera(mouseX, mouseY, depth) <= r[j].distanceFromCamera(mouseX, mouseY, depth)) {
                polygons[k++] = l[i++];
            }
            else {
                polygons[k++] = r[j++];
            }
        }
        while (i < left) {
            polygons[k++] = l[i++];
        }
        while (j < right) {
            polygons[k++] = r[j++];
        }
    }

}
