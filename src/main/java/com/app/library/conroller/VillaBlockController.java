package com.app.library.conroller;

import com.app.library.dao.block.VillasBlock;
import com.app.library.dto.blockdto.VillasBlockDto;
import com.app.library.services.impl.VillaBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/villaBlocks")
public class VillaBlockController {

    @Autowired
    private VillaBlockService villaBlockService;

    @PostMapping("/create")
    public VillasBlockDto createVillaBlock(@RequestBody VillasBlockDto blockDto) {
        return villaBlockService.save(blockDto);
    }

    @GetMapping("/{id}")
    public VillasBlockDto getVillaBlockById(@PathVariable Integer id) {
        return villaBlockService.findById(id);
    }

    @GetMapping("/getAll")
    public List<VillasBlockDto> getAllVillaBlocks() {
        return villaBlockService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteVillaBlock(@PathVariable Integer id) {
        villaBlockService.delete(id);
    }
}
