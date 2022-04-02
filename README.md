# SofkaFrameworkWebTests

Para la gestión de las evidencias de una ejecución de pruebas se requiere
cambiar el valor de la propiedad **files.evidence** en la ruta del proyecto *src/main/resources/properties/configuration.properties*.

La ruta que se parametrice deberá ser acorde a la ruta local donde se guarde el proyecto para hacer las pruebas. Por ejemplo:

- Por defecto, la propiedad tiene el siguiente valor:

```bash
C://sofka//framework//SofkaFrameworkWebTests//src//main//resources//evidence
```

- Por lo tanto, se debe cambiar la ruta hasta el source del proyecto.
Es decir, reemplazar ...

```bash
C://sofka//framework//SofkaFrameworkWebTests
```
- por la ruta de la máquina local.
