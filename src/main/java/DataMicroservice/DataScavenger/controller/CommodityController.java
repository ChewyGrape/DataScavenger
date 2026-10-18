package DataMicroservice.DataScavenger.controller;

import DataMicroservice.DataScavenger.entity.Commodity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import DataMicroservice.DataScavenger.service.CommodityService;

@RestController
@RequestMapping("/commodity")
@RequiredArgsConstructor
public class CommodityController {
    private final CommodityService service;

    @PostMapping("/fetch")
    public Commodity fetchSilverPrice() {
        System.out.println("Triggered");
        return service.fetchAndSaveGoldPrice();
    }
}
