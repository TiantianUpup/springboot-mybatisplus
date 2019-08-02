package com.h2t.study;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TODO Description
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2019/08/02 16:48
 */
@Service
public class UserService {
    @Resource
    private UserDAO userDAO;
    //增
    public int addAnimal(User user) {
        return userDAO.insert(user);
    }

    //删
    public ResponseEntity<Integer> deleteAnimalById(final int id){
        return ResponseEntity.ok(animalRepository.deleteById(id));
    }

    public ResponseEntity<Integer> deleteAnimals(final Animal animal){
        return ResponseEntity.ok(animalRepository.delete(packWrapper(animal, WrapperType.QUERY)));
    }

    public ResponseEntity<Integer> deleteAnimalsByIds(List<Integer> ids){
        return ResponseEntity.ok(animalRepository.deleteBatchIds(ids));
    }

    public ResponseEntity<Integer> deleteAnimalsByMap(final Animal animal){
        Map<String, Object> params = new HashMap<>();
        if(Objects.nonNull(animal.getId())){
            params.put("ID",animal.getId());
        }
        if(StringUtils.isNotEmpty(animal.getName())){
            params.put("NAME", animal.getName());
        }
        if(Objects.nonNull(animal.getType())){
            params.put("TYPE", animal.getType());
        }
        if(Objects.nonNull(animal.getSex())){
            params.put("SEX", animal.getSex());
        }
        if (StringUtils.isNotEmpty(animal.getMaster())){
            params.put("MASTER", animal.getMaster());
        }
        return ResponseEntity.ok(animalRepository.deleteByMap(params));
    }

    //改
    public ResponseEntity<Integer> updateAnimals(final Animal animal, final Animal condition){
        return ResponseEntity.ok(animalRepository.update(animal, packWrapper(condition, WrapperType.UPDATE)));
    }

    public ResponseEntity<Integer> updateAnimal(final Animal animal){
        Wrapper<Animal> animalWrapper = new UpdateWrapper<>();
        ((UpdateWrapper<Animal>) animalWrapper).eq("id",animal.getId());
        return ResponseEntity.ok(animalRepository.update(animal, animalWrapper));
    }

    //查
    public ResponseEntity<Animal> getAnimalById(final int id){
        return ResponseEntity.ok(animalRepository.selectById(id));
    }

    public ResponseEntity<Animal> getOneAnimal(final Animal animal){
        return ResponseEntity.ok(animalRepository.selectOne(packWrapper(animal, WrapperType.QUERY)));
    }

    public ResponseEntity<List<Animal>> getAnimals(final Animal animal){
        return ResponseEntity.ok(animalRepository.selectList(packWrapper(animal, WrapperType.QUERY)));
    }

    public ResponseEntity<List<Animal>> getAnimalsByIds(List<Integer> ids){
        return ResponseEntity.ok(animalRepository.selectBatchIds(ids));
    }

    public ResponseEntity<List<Animal>> getAnimalsByMap(final Animal animal){
        Map<String, Object> params = new HashMap<>();
        if(Objects.nonNull(animal.getId())){
            params.put("ID",animal.getId());
        }
        if(StringUtils.isNotEmpty(animal.getName())){
            params.put("NAME", animal.getName());
        }
        if(Objects.nonNull(animal.getType())){
            params.put("TYPE", animal.getType());
        }
        if(Objects.nonNull(animal.getSex())){
            params.put("SEX", animal.getSex());
        }
        if (StringUtils.isNotEmpty(animal.getMaster())){
            params.put("MASTER", animal.getMaster());
        }
        return ResponseEntity.ok(animalRepository.selectByMap(params));
    }

    public ResponseEntity<List<Map<String, Object>>> getAnimalMaps(final Animal animal){
        return ResponseEntity.ok(animalRepository.selectMaps(packWrapper(animal, WrapperType.QUERY)));
    }

    //查个数
    public ResponseEntity<Integer> getCount(final Animal animal){
        return ResponseEntity.ok(animalRepository.selectCount(packWrapper(animal, WrapperType.QUERY)));
    }

    //分页查询
    public ResponseEntity<Page<Animal>> getAnimalPage(final Animal animal,final int pageId,final int pageSize){
        Page<Animal> page = new Page<>();
        page.setCurrent(pageId);
        page.setSize(pageSize);
        return ResponseEntity.ok((Page<Animal>) animalRepository.selectPage(page,packWrapper(animal, WrapperType.QUERY)));
    }

    private Wrapper<Animal> packWrapper(final Animal animal, WrapperType wrapperType){
        switch (wrapperType){
            case QUERY:
                QueryWrapper<Animal> wrapper = new QueryWrapper<>();
                if (Objects.nonNull(animal.getId()))
                    wrapper.eq("ID", animal.getId());
                if (StringUtils.isNotEmpty(animal.getName()))
                    wrapper.eq("name", animal.getName());
                if (Objects.nonNull(animal.getType()))
                    wrapper.eq("type", animal.getType());
                if (Objects.nonNull(animal.getSex()))
                    wrapper.eq("sex", animal.getSex());
                if (StringUtils.isNotEmpty(animal.getMaster()))
                    wrapper.eq("master", animal.getMaster());
                return wrapper;
            case UPDATE:
                UpdateWrapper<Animal> wrapper2 = new UpdateWrapper<>();
                if (Objects.nonNull(animal.getId()))
                    wrapper2.eq("ID", animal.getId());
                if (StringUtils.isNotEmpty(animal.getName()))
                    wrapper2.eq("name", animal.getName());
                if (Objects.nonNull(animal.getType()))
                    wrapper2.eq("type", animal.getType());
                if (Objects.nonNull(animal.getSex()))
                    wrapper2.eq("sex", animal.getSex());
                if (StringUtils.isNotEmpty(animal.getMaster()))
                    wrapper2.eq("master", animal.getMaster());
                return wrapper2;
            case QUERYLAMBDA:
                LambdaQueryWrapper<Animal> wrapper3 = new QueryWrapper<Animal>().lambda();
                if (Objects.nonNull(animal.getId()))
                    wrapper3.eq(Animal::getId, animal.getId());
                if (StringUtils.isNotEmpty(animal.getName()))
                    wrapper3.eq(Animal::getName, animal.getName());
                if (Objects.nonNull(animal.getType()))
                    wrapper3.eq(Animal::getType, animal.getType());
                if (Objects.nonNull(animal.getSex()))
                    wrapper3.eq(Animal::getSex, animal.getSex());
                if (StringUtils.isNotEmpty(animal.getMaster()))
                    wrapper3.eq(Animal::getMaster, animal.getMaster());
                return wrapper3;
            case UPDATELAMBDA:
                LambdaUpdateWrapper<Animal> wrapper4 = new UpdateWrapper<Animal>().lambda();
                if (Objects.nonNull(animal.getId()))
                    wrapper4.eq(Animal::getId, animal.getId());
                if (StringUtils.isNotEmpty(animal.getName()))
                    wrapper4.eq(Animal::getName, animal.getName());
                if (Objects.nonNull(animal.getType()))
                    wrapper4.eq(Animal::getType, animal.getType());
                if (Objects.nonNull(animal.getSex()))
                    wrapper4.eq(Animal::getSex, animal.getSex());
                if (StringUtils.isNotEmpty(animal.getMaster()))
                    wrapper4.eq(Animal::getMaster, animal.getMaster());
                return wrapper4;
            default:return null;
        }
    }
}
