//
//  PodiumsDAO.swift
//  IOS project Chiel
//
//  Created by chiel bleyenbergh on 01/02/2019.
//  Copyright © 2019 ehb. All rights reserved.
//

import Foundation

class PodiumsDAO {
    
    var stages:[Podium]?
    
    init() {
        let stage1 = Podium.init(name: "Mainstage", image: "Mainstage.png")
        let stage2 = Podium.init(name: "Fishstage", image: "Fishstage.png")
        
        self.stages = [stage1, stage2]
        
    }
}
