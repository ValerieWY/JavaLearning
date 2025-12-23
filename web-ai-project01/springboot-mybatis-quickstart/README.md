Error：
单独运行单测时，会报 NoSuchMethodError: 'java.lang.Object org.junit.jupiter.api.extension.ExtensionContext$Store.computeIfAbsent(java.lang.Object, java.util.function.Function, java.lang.Class)'

核心原因：
Spring Boot 4.0.1 内置的 spring-test 版本，和它默认依赖的 JUnit 6.0.1 本身就不兼容，
二者对 ExtensionContext.Store.computeIfAbsent 方法的定义不匹配，和 “是否存在多个 JUnit 版本” 无关。

具体拆解：
JUnit 6.0.1 的 API 变更JUnit 6.0.1 对 ExtensionContext.Store 的 computeIfAbsent 方法做了签名重构：
删除了 (Object, Function, Class) 这个重载版本，只保留了其他参数的重载形式。
而 Spring Boot 4.0.1 内置的 spring-test 模块（版本对应 Spring 6.1.x），
其 SpringExtension 类硬编码调用的就是被删除的这个重载方法。

解决方案：
<!-- 核心：强制指定JUnit 5.10.1，覆盖Spring Boot 4.x的6.x默认值 -->
    <properties>
        <junit-jupiter.version>5.10.1</junit-jupiter.version>
        <junit-platform.version>1.10.1</junit-platform.version>
    <!-- 新增：指定spring-test版本，适配JUnit 5.10.1 -->
        <spring-test.version>6.1.2</spring-test.version>
    </properties>

  <!-- 显式引入兼容的JUnit 5.10.1 -->
	<dependency>
        <artifactId>junit-jupiter</artifactId>
        <groupId>org.junit.jupiter</groupId>
        <version>5.10.1</version>
    </dependency>
   <!-- 原有依赖不变，新增spring-test显式依赖 -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-test</artifactId>
        <version>${spring-test.version}</version>
        <scope>test</scope>
    </dependency>
