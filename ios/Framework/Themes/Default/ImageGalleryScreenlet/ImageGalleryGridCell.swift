//
//  ImageGalleryGridCell.swift
//  LiferayScreens
//
//  Created by liferay on 20/07/16.
//  Copyright © 2016 Liferay. All rights reserved.
//

import UIKit

public class ImageGalleryGridCell: UICollectionViewCell {

	@IBOutlet private weak var previewImage: UIImageView!

	public var imageUrl: String  {
		get {
			return ""
		}
		set {
			previewImage.setImageWithURL(NSURL(string: newValue ?? "")!)
		}
	}

	public override func awakeFromNib() {
		previewImage.clipsToBounds = true
	}

	public override func prepareForReuse() {
		previewImage.image = nil
	}
}
