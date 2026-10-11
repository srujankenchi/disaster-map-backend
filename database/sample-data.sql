-- Global Disaster and Human Impact Map
-- Sample Dataset for MySQL 8.x
-- Historical records are compiled from public international disaster records (EM-DAT / USGS / NOAA / UN OCHA).
-- Any demonstration or synthetic records are explicitly annotated.

USE global_disaster_db;

INSERT INTO disasters (
    disaster_name, disaster_type, country, location, latitude, longitude,
    occurrence_date, severity, description,
    fatalities, injuries, affected_population, displaced_population, economic_damage
) VALUES
-- 1. 2004 Indian Ocean Tsunami
(
    '2004 Indian Ocean Earthquake and Tsunami', 'Tsunami', 'Indonesia', 'Off west coast of northern Sumatra', 3.3160000, 95.8540000,
    '2004-12-26', 'Catastrophic', 'A magnitude 9.1-9.3 undersea megathrust earthquake triggered devastating tsunamis across the Indian Ocean coastline impacting 14 countries.',
    227898, 125000, 1700000, 1700000, 15000000000.00
),
-- 2. 2011 Tohoku Earthquake and Tsunami
(
    '2011 Tohoku Earthquake and Tsunami', 'Earthquake', 'Japan', 'Tohoku region, Miyagi coast', 38.3220000, 142.3690000,
    '2011-03-11', 'Catastrophic', 'A massive Mw 9.1 undersea earthquake followed by tsunamis reaching up to 40 meters, triggering the Fukushima Daiichi nuclear accident.',
    19759, 6242, 368995, 470000, 235000000000.00
),
-- 3. 2010 Haiti Earthquake
(
    '2010 Port-au-Prince Haiti Earthquake', 'Earthquake', 'Haiti', 'Leogane, near Port-au-Prince', 18.4570000, -72.5330000,
    '2010-01-12', 'Catastrophic', 'Catastrophic magnitude 7.0 Mw earthquake causing severe structural collapse across Port-au-Prince and surrounding communes.',
    160000, 300000, 3000000, 1500000, 8000000000.00
),
-- 4. 2005 Hurricane Katrina
(
    'Hurricane Katrina', 'Hurricane', 'United States', 'Gulf Coast, Louisiana and Mississippi', 29.9511000, -90.0715000,
    '2005-08-29', 'Extreme', 'Category 5 Atlantic hurricane that breached the levee protection system in New Orleans, resulting in massive flooding and coastal devastation.',
    1836, 12000, 1500000, 1000000, 125000000000.00
),
-- 5. 2023 Turkey-Syria Earthquake
(
    '2023 Turkey-Syria Earthquake Sequence', 'Earthquake', 'Turkey', 'Kahramanmaras and Gaziantep province', 37.1740000, 37.0320000,
    '2023-02-06', 'Catastrophic', 'Doublet earthquakes of Mw 7.8 and 7.5 caused widespread collapse of tens of thousands of residential buildings across southeastern Turkey and northern Syria.',
    59259, 107204, 14000000, 3300000, 104000000000.00
),
-- 6. 2008 Sichuan Earthquake
(
    '2008 Sichuan Earthquake', 'Earthquake', 'China', 'Wenchuan County, Sichuan Province', 31.0020000, 103.3220000,
    '2008-05-12', 'Catastrophic', 'Magnitude 7.9 earthquake striking the Longmenshan fault zone, causing massive mountain landslides and building collapse.',
    87587, 374643, 46250000, 4800000, 150000000000.00
),
-- 7. 2022 Pakistan Monsoon Floods
(
    '2022 Pakistan Floods', 'Flood', 'Pakistan', 'Sindh and Balochistan provinces', 27.5598000, 68.2096000,
    '2022-06-14', 'Extreme', 'Extreme monsoon rains and accelerated glacial melt submerged one-third of Pakistan, impacting millions of agricultural livelihoods.',
    1739, 12867, 33000000, 7900000, 30100000000.00
),
-- 8. 2013 Typhoon Haiyan
(
    'Super Typhoon Haiyan (Yolanda)', 'Cyclone', 'Philippines', 'Eastern Visayas, Tacloban City', 11.2442000, 125.0039000,
    '2013-11-08', 'Extreme', 'One of the most powerful tropical cyclones ever recorded, generating destructive storm surges and 315 km/h sustained wind speeds.',
    7354, 28688, 16000000, 4100000, 5800000000.00
),
-- 9. 2019-2020 Australian Black Summer Bushfires
(
    'Australian Black Summer Bushfires', 'Wildfire', 'Australia', 'New South Wales and Victoria', -35.2809000, 149.1300000,
    '2019-09-05', 'Severe', 'Unprecedented mega-fires burned over 24 million hectares of temperate forests, generating massive smoke plumes and wildlife loss.',
    33, 447, 3000000, 65000, 23000000000.00
),
-- 10. 2015 Nepal Gorkha Earthquake
(
    '2015 Gorkha Nepal Earthquake', 'Earthquake', 'Nepal', 'Gorkha district, northwest of Kathmandu', 28.1470000, 84.7080000,
    '2015-04-25', 'Extreme', 'Magnitude 7.8 earthquake killing thousands, destroying historic monuments in Kathmandu Valley, and triggering Mount Everest avalanches.',
    8964, 22300, 8100000, 2800000, 10000000000.00
),
-- 11. 2021 European Floods
(
    '2021 European Floods', 'Flood', 'Germany', 'Rhineland-Palatinate and North Rhine-Westphalia', 50.5432000, 7.1132000,
    '2021-07-12', 'Severe', 'Severe flash floods from torrential rainfall along the Ahr and Erft river basins destroyed bridges, rail lines, and historic towns.',
    243, 766, 200000, 40000, 43000000000.00
),
-- 12. 2017 Hurricane Maria
(
    'Hurricane Maria', 'Hurricane', 'United States', 'Puerto Rico and Dominica', 18.2208000, -66.5901000,
    '2017-09-20', 'Catastrophic', 'Intense Category 5 hurricane caused a total blackout across Puerto Rico and catastrophic damage to housing, communications, and electrical grid.',
    2975, 4000, 3400000, 130000, 91600000000.00
),
-- 13. 2008 Cyclone Nargis
(
    'Cyclone Nargis', 'Cyclone', 'Myanmar', 'Ayeyarwady and Yangon divisions', 16.0270000, 95.1200000,
    '2008-05-02', 'Catastrophic', 'Category 4 cyclone drove a 4-meter storm surge 40 kilometers inland across the densely populated low-lying Irrawaddy Delta.',
    138373, 19359, 2400000, 800000, 12900000000.00
),
-- 14. 2020-2023 Horn of Africa Drought
(
    'Horn of Africa Multi-Year Drought', 'Drought', 'Somalia', 'Somalia, eastern Ethiopia, northern Kenya', 5.1521000, 46.1996000,
    '2020-10-15', 'Extreme', 'Five consecutive failed rainy seasons created severe water scarcity, millions of livestock deaths, and extreme food insecurity.',
    43000, 0, 36000000, 2300000, 4500000000.00
),
-- 15. 2018 Camp Fire
(
    'Camp Fire Wildfire', 'Wildfire', 'United States', 'Butte County, Paradise, California', 39.8106000, -121.4372000,
    '2018-11-08', 'Severe', 'The deadliest and most destructive wildfire in California history, virtually annihilating the town of Paradise within hours.',
    85, 12, 52000, 50000, 16650000000.00
),
-- 16. 2022 Hunga Tonga Volcanic Eruption
(
    'Hunga Tonga-Hunga Haapai Volcanic Eruption', 'Volcanic Eruption', 'Tonga', 'Hunga Tonga submarine caldera', -20.5360000, -175.3820000,
    '2022-01-15', 'Extreme', 'Explosive submarine eruption generated an atmospheric shockwave that circled the globe multiple times and trans-oceanic tsunamis.',
    4, 18, 84000, 3000, 182000000.00
),
-- 17. 2013 Kedarnath Uttarakhand Floods
(
    'Uttarakhand Flash Floods and Debris Flow', 'Flood', 'India', 'Kedarnath, Uttarakhand Himalayas', 30.7346000, 79.0669000,
    '2013-06-16', 'Extreme', 'Multi-day cloudbursts and moraine-dammed lake breach (Chorabari Tal) triggered catastrophic debris flows engulfing pilgrimage sites.',
    5748, 4473, 4200000, 110000, 1100000000.00
),
-- 18. 2020 Super Cyclone Amphan
(
    'Super Cyclone Amphan', 'Cyclone', 'India', 'West Bengal, Sundarbans and Odisha', 21.6500000, 88.3000000,
    '2020-05-20', 'Severe', 'Super cyclonic storm tore through the Sundarbans mangrove delta and the metropolis of Kolkata with heavy wind gusts and coastal surge.',
    128, 500, 18000000, 4900000, 13500000000.00
),
-- 19. 2023 Canadian Wildfires
(
    '2023 Canadian Wildfire Crisis', 'Wildfire', 'Canada', 'Quebec, Alberta, Northwest Territories', 53.9333000, -116.5765000,
    '2023-05-01', 'Severe', 'Canada record-shattering wildfire season scorched over 18 million hectares, forcing large evacuations and creating hazardous smoke across North America.',
    8, 95, 232000, 200000, 7500000000.00
),
-- 20. 2019 Cyclone Idai
(
    'Cyclone Idai', 'Cyclone', 'Mozambique', 'Beira and Sofala Province', -19.8315000, 34.8381000,
    '2019-03-15', 'Catastrophic', 'Tropical cyclone brought immense rainfall and inland flooding that inundated 90% of the port city of Beira and surrounding agricultural land.',
    1303, 2600, 3000000, 146000, 2200000000.00
),
-- 21. 2010 Eyjafjallajokull Volcanic Eruption
(
    'Eyjafjallajokull Volcano Eruption', 'Volcanic Eruption', 'Iceland', 'Southern Iceland ice cap', 63.6330000, -19.6000000,
    '2010-04-14', 'Moderate', 'Subglacial explosive eruption produced an airborne ash plume that grounded commercial aviation across European airspace for weeks.',
    0, 0, 50000, 800, 4700000000.00
),
-- 22. 2017 Sierra Leone Mudslide
(
    'Freetown Regent Mudslide', 'Landslide', 'Sierra Leone', 'Regent, Sugar Loaf Mountain, Freetown', 8.4419000, -13.2081000,
    '2017-08-14', 'Extreme', 'Heavy torrential rainfall triggered a massive hillside collapse that buried settlements in Regent and downstream communities.',
    1141, 600, 20000, 7000, 32000000.00
),
-- 23. 2024 Wayanad Landslides
(
    '2024 Wayanad Landslides', 'Landslide', 'India', 'Chooralmala and Meppadi, Wayanad, Kerala', 11.5380000, 76.1780000,
    '2024-07-30', 'Severe', 'Devastating nocturnal landslides sparked by heavy monsoon rains washed away several tea estate hamlets and bridge connections.',
    420, 397, 10000, 9500, 145000000.00
),
-- 24. 2021 Henan Floods
(
    '2021 Henan Province Torrential Floods', 'Flood', 'China', 'Zhengzhou, Henan Province', 34.7466000, 113.6253000,
    '2021-07-17', 'Extreme', 'Historic torrential rainfall flooded road tunnels, subway lines, and reservoirs across Zhengzhou and neighboring cities.',
    398, 200, 14500000, 1470000, 17700000000.00
),
-- 25. 2015-2018 Cape Town Water Crisis
(
    'Cape Town Day Zero Drought Crisis', 'Drought', 'South Africa', 'Western Cape Province', -33.9249000, 18.4241000,
    '2017-03-01', 'Severe', 'Prolonged multi-year drought nearly depleted dam reservoirs, bringing the metropolitan region to the brink of complete municipal water shutoff.',
    0, 0, 4000000, 0, 1200000000.00
),
-- 26. 2018 Fuego Volcanic Eruption
(
    'Volcan de Fuego Pyroclastic Eruption', 'Volcanic Eruption', 'Guatemala', 'Escuintla and Sacatepequez', 14.4747000, -90.8808000,
    '2018-06-03', 'Severe', 'Fast-moving pyroclastic density currents engulfed the village of San Miguel Los Lotes with minimal evacuation warning.',
    431, 27, 1714000, 12800, 219000000.00
),
-- 27. 2023 Derna Dam Collapses and Flood
(
    'Storm Daniel and Derna Dam Collapse', 'Flood', 'Libya', 'Derna, Cyrenaica region', 32.7667000, 22.6333000,
    '2023-09-10', 'Catastrophic', 'Storm Daniel triggered the breach of two upstream dams along Wadi Derna, sending a 7-meter wave that swept a quarter of the coastal city into the Mediterranean.',
    11300, 8000, 250000, 44000, 1800000000.00
),
-- 28. 2020 Petrinja Earthquake
(
    '2020 Petrinja Earthquake', 'Earthquake', 'Croatia', 'Sisak-Moslavina County, Petrinja', 45.4002000, 16.2187000,
    '2020-12-29', 'Moderate', 'A magnitude 6.4 earthquake struck central Croatia causing structural damage in Petrinja, Sisak, and Zagreb.',
    7, 26, 50000, 3000, 5500000000.00
),
-- 29. 2019 European Heatwave and Wildfires
(
    '2019 Western European Extreme Heatwave', 'Wildfire', 'France', 'Occitanie and Provence', 43.6047000, 1.4442000,
    '2019-06-25', 'Severe', 'Record-breaking summer heatwave with temperatures reaching 46C sparked agricultural wildfires and severe heat stress across France and Spain.',
    1435, 1200, 1500000, 1200, 3100000000.00
),
-- 30. 2024 Noto Peninsula Earthquake
(
    '2024 Noto Peninsula Earthquake', 'Earthquake', 'Japan', 'Ishikawa Prefecture, Wajima', 37.4980000, 137.2420000,
    '2024-01-01', 'Severe', 'Shallow magnitude 7.5 earthquake caused building collapse, ground liquefaction, coastal uplift, and a major fire in Wajima morning market.',
    400, 1300, 120000, 34000, 17600000000.00
),
-- 31. 2022 Brazilian Petropolis Floods and Landslides
(
    'Petropolis Flash Floods and Mudslides', 'Landslide', 'Brazil', 'Rio de Janeiro State, Petropolis', -22.5050000, -43.1789000,
    '2022-02-15', 'Severe', 'Intense cloudburst rainfall generated severe street torrents and mudslides in mountainous areas of Petropolis.',
    231, 0, 30000, 1100, 200000000.00
),
-- 32. 2021 Hurricane Ida
(
    'Hurricane Ida', 'Hurricane', 'United States', 'Louisiana coast to Northeast corridor', 29.2310000, -90.0120000,
    '2021-08-29', 'Extreme', 'Category 4 hurricane struck Port Fourchon Louisiana before remnant circulation brought catastrophic record basement flooding to New York and New Jersey.',
    107, 150, 1200000, 25000, 75000000000.00
),
-- 33. Demonstration Record 1
(
    '[Demo Simulation] Coastal Surge Response Exercise', 'Flood', 'Netherlands', 'Rotterdam Delta Port Zone', 51.9244000, 4.4777000,
    '2025-03-15', 'Moderate', '[Synthetic Demonstration Record] Emergency training scenario evaluating storm surge barrier deployment and coastal evacuations.',
    0, 15, 25000, 1200, 5000000.00
),
-- 34. Demonstration Record 2
(
    '[Demo Simulation] Alpine Rockfall Scenario', 'Landslide', 'Switzerland', 'Valais Cantonal Valley', 46.2276000, 7.3589000,
    '2025-05-20', 'Low', '[Synthetic Demonstration Record] Synthetic monitoring exercise assessing alpine permafrost rockfall sensor networks and rail rerouting.',
    0, 2, 1200, 80, 850000.00
);
