package me.devhardy.locationpharmacy.pharmacy.repository;

import me.devhardy.locationpharmacy.pharmacy.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> { }
