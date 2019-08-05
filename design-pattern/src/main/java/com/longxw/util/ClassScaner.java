package com.longxw.util;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.StringUtils;
import org.springframework.util.SystemPropertyUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.*;

public class ClassScaner implements ResourceLoaderAware {

    private final List<TypeFilter> includeFilters = new LinkedList<>();
    private final List<TypeFilter> excludeFilters = new LinkedList<>();

    private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
    private MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(this.resourcePatternResolver);

    public static Set<Class<?>> scan(String[] basePackages, Class<? extends Annotation>... annotations){
        ClassScaner classScaner = new ClassScaner();
        classScaner.addIncludeFilters(annotations);
        Set<Class<?>> classSet = new HashSet<>();
        for(String s : basePackages){
            classSet.addAll(classScaner.doScan(s));
        }
        return classSet;
    }

    public static Set<Class<?>> scan(String basePackages,Class<? extends Annotation>... annotations){
        return ClassScaner.scan(StringUtils.tokenizeToStringArray(basePackages,",; \t\n"),annotations);
    }

    public Set<Class<?>> doScan(String basePackage){
        Set<Class<?>> classSet = new HashSet<>();
        try{
            String packageSearchPath = buildPackageSearchPath(basePackage);
            Resource[]  resources = this.resourcePatternResolver.getResources(packageSearchPath);
            for(Resource resource : resources){
                if(resource.isReadable()){
                    MetadataReader metadataReader = this.metadataReaderFactory.getMetadataReader(resource);
                    if( (includeFilters.isEmpty() && excludeFilters.isEmpty()) || matches(metadataReader)){
                        classSet.add(Class.forName(metadataReader.getClassMetadata().getClassName()));
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return classSet;
    }

    protected boolean matches(MetadataReader metadataReader) throws IOException {
        for(TypeFilter typeFilter : this.excludeFilters){
            if(typeFilter.match(metadataReader,this.metadataReaderFactory)){
                return false;
            }
        }

        for(TypeFilter typeFilter : this.includeFilters){
            if(typeFilter.match(metadataReader,this.metadataReaderFactory)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourcePatternResolver = ResourcePatternUtils.getResourcePatternResolver(resourceLoader);
        this.metadataReaderFactory = new CachingMetadataReaderFactory(resourceLoader);
    }

    public void addIncludeFilters(Class<? extends Annotation>... annotations){
        for(Class item : annotations){
            this.addIncludeFilter(new AnnotationTypeFilter(item));
        }
    }

    public void addIncludeFilter(TypeFilter typeFilter){
        this.includeFilters.add(typeFilter);
    }

    private static String buildPackageSearchPath(String basePackage){
        return ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + org.springframework.util.ClassUtils.convertClassNameToResourcePath(SystemPropertyUtils.resolvePlaceholders(basePackage)) + "/**/*.class";
    }
}
