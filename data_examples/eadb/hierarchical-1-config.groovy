fields = [
        ID               : [
                type: Integer.class
        ],
        CAS_NUMBER       : [
                category: "Compound"
                // name: "renamed"
        ],
        COMPOUND_CODE    : [
                category: "Compound",
                type    : Integer.class
        ],
        COMPOUND_NAME    : [
                category: "Compound"
        ],
        FMLA             : [
                category: "Compound"
        ],
        MOLECULAR_WEIGHT : [
                category: "Compound",
                type    : Float.class
        ],
        KOWLOGP          : [
                category: "Compound",
                type    : Float.class
        ],
        STRUCTURECATEGORY: [
                category: "Compound"
        ],
        SMILES           : [
                category: "Compound"
        ],
        AUTHORS          : [
                category: "Citation"
        ],
        JOURNAL          : [
                category: "Citation"
        ],
        PUBLICATION_DATE : [
                category: "Citation",
                type    : Integer.class
        ],
        VOLUME_NUMBER    : [
                category: "Citation",
                type    : Integer.class
        ],
        START_PAGE       : [
                category: "Citation",
                type    : Integer.class
        ],
        SOURCE_URL       : [
                category: "Citation"
        ],
        ASSAY_CLASS_NAME : [
                category: "Assay"
        ],
        ASSAY_NAME       : [
                category: "Assay"
        ],
        SPECIES_STRAIN   : [
                category: "Assay"
        ],
        ENDPOINT_NAME    : [:],
        ENDPOINT_VALUE   : [
                type    : Float.class
        ],
        ENDPOINT_UNIT    : [:],
        PROTEIN_SUBTYPE  : [
                category: "Assay"
        ],
        PROTEIN_DOMAIN   : [
                category: "Assay"
        ],
        ROUTE_OF_COMPOUND: [
                category: "Assay"
        ]
]